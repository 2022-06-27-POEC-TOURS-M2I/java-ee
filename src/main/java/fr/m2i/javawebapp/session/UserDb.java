package fr.m2i.javawebapp.session;

import java.util.ArrayList;
import java.util.List;

public class UserDb {

    private static List<User> users = new ArrayList() {
        {
            add(new User("admin@admin.com", "admin", Role.ADMIN));
            add(new User("user@user.com", "user", Role.USER));
        }
    };

    public static User checkUser(String email, String password) {

        if (email == null || password == null) {
            return null;
        }

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
