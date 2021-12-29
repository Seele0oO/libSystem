package com.seele0oO.jdbc.Unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Function;

public final class DBInJ {
	public static final String database = "bookmanager";
	public static final String user = "root";
	public static final String password = "mysqlqsqsqsq";

	private DBInJ() {
	}

	@FunctionalInterface
	public static interface IAdvancedRunnable<R> extends Runnable {
		R run(Object... args) throws Throwable;

		@Override
		default void run() {
			this.invoke();
		}

		static void ct(final Throwable e) {
			if (e instanceof Error) {
				throw (Error) e;
			} else if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw new RuntimeException(e);
			}
		}

		default R invoke(final Object... args) {
			try {
				return this.run(args);
			} catch (final Throwable e) {
				IAdvancedRunnable.ct(e);
			}
			return null;
		}

		static <R> R invoke(final IAdvancedRunnable<R> r, final Object... args) {
			return r.invoke(args);
		}

		static IAdvancedRunnable<Void> fromRunnable(final Runnable r) {
			return args ->
			{
				r.run();
				return null;
			};
		}
	}

	@FunctionalInterface
	public static interface IGenericAdvancedRunnable<T, R> extends Function<T, R> {
		R run(T arg) throws Throwable;

		@Override
		default R apply(final T arg) {
			return this.invoke(arg);
		}

		default R invoke(final T arg) {
			try {
				return this.run(arg);
			} catch (final Throwable e) {
				IAdvancedRunnable.ct(e);
			}
			return null;
		}

		static <T, R> R invoke(final IGenericAdvancedRunnable<T, R> r, final T arg) {
			return r.invoke(arg);
		}

		static <T, R> IGenericAdvancedRunnable<T, R> fromFunction(final Function<T, R> func) {
			return func::apply;
		}
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (final ClassNotFoundException ignore) {
			IAdvancedRunnable.invoke(args -> Class.forName("com.mysql.jdbc.Driver"));
		}
	}

	public static Connection openConnection() {
		return IAdvancedRunnable.invoke(args -> DriverManager.getConnection(
				"jdbc:mysql://106.15.66.141:3306/" + DBInJ.database + "?characterEncoding=utf-8&serverTimezone=GMT%2B8", DBInJ.user,
				DBInJ.password));
	}

	public static <R> R fastQuery(final IGenericAdvancedRunnable<Connection, R> func) {
		return IAdvancedRunnable.invoke(args ->
		{
			try (final Connection connection = DBInJ.openConnection()) {
				return func.invoke(connection);
			}
		});
	}

	public static boolean fastPreparedExecute(final String sql, final Object... args) {
		return DBInJ.fastQuery(con ->
		{
			try (final PreparedStatement prepareStatement = con.prepareStatement(sql)) {
				for (int i = 1; i <= args.length; i++) {
					prepareStatement.setObject(i, args[i - 1]);
				}
				return prepareStatement.execute();
			}
		});
	}

	public static int fastPreparedExecuteUpdate(final String sql, final Object... args) {
		return DBInJ.fastQuery(con ->
		{
			try (final PreparedStatement prepareStatement = con.prepareStatement(sql)) {
				for (int i = 1; i <= args.length; i++) {
					prepareStatement.setObject(i, args[i - 1]);
				}
				return prepareStatement.executeUpdate();
			}
		});
	}

	public static <R> R fastPreparedExecuteQuery(final String sql, final IGenericAdvancedRunnable<ResultSet, R> func,
	                                             final Object... args) {
		return DBInJ.fastQuery(con ->
		{
			try (final PreparedStatement prepareStatement = con.prepareStatement(sql)) {
				for (int i = 1; i <= args.length; i++) {
					prepareStatement.setObject(i, args[i - 1]);
				}
				try (final ResultSet r = prepareStatement.executeQuery()) {
					return func.invoke(r);
				}
			}
		});
	}
}