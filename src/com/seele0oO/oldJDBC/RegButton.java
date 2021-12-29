package com.seele0oO.oldJDBC;

// import com.qlulu6.libSystem.jdbc.*;
import com.qlulu6.libSystem.jdbc.dao.UserDao;
import com.qlulu6.libSystem.jdbc.dao.UserDaoimpl;
import com.qlulu6.libSystem.jdbc.model.User;

public class RegButton {
    public static boolean reg(String username, String password, String sex, String phone) {
        /*
        UserDao sd= (UserDao) new UserDaoimpl();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setPhone(phone);
        user.setRole(1);//1普通用户，2管理员
        
        sd.addUser(user);
        */
        return true;
    }
}


