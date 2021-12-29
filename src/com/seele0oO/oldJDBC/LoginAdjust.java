package com.seele0oO.oldJDBC;

import com.seele0oO.oldJDBC.dao.UserDao;
import com.seele0oO.oldJDBC.dao.UserDaoimpl;
import com.seele0oO.oldJDBC.model.User;

public class LoginAdjust {
    public static User currentUser;
    private static final String get_username = null;
    private static final String get_password = null;

    private static int findByUsrname(String username, String password) {
        UserDao sd = (UserDao) new UserDaoimpl();
        User byname;

        try {
            byname = sd.findByname(username);
            String password1 = byname.getPassword();
            // String isadmin = byname.getIsadmin();
            if (password1.equals(password)) {
                currentUser = byname;
                currentUser.getUsername();
                return 0;// success

            } else {
                return 1;// failure
            }
        } catch (NullPointerException e) {
            System.out.println("未找到用户");
            return 2;
        }
        // return false;
    }

    // todo: 对接后端
    public static int confirm(String username, String password) {
        int result = findByUsrname(username, password);
        System.out.println(currentUser);
        return result;
    }

}
