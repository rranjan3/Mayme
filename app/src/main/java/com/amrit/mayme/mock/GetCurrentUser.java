package com.amrit.mayme.mock;

import com.amrit.mayme.core.User;

public class GetCurrentUser {
    public static User getCurrentUser(){
         User u = new User("amrit",  "amrit44@gmail.com", "password123",332);

         return  u;
    }
}
