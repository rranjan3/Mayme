package com.amrit.mayme.model;

import com.amrit.mayme.core.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    static List<User> users = new ArrayList<>();
    public static List<User> getUsers(){
        users.add( new User("motorola", "motorola18@gmail.com" ,"@motorola234", 34));
        users.add( new User("amrit",  "amrit44@gmail.com", "password123",332));
        users.add( new User("ritu",  "rituverma@gmail.com", "passwd456",12));
        users.add( new User("john_88",  "john_88@yahoo.com", "johnwithmarry3",684));
        users.add( new User("bigbro", "bigbro73not@adobe.com", "india7123",67));
        return users;
    }
}
