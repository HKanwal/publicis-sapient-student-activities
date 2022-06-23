package com.sapient.lesson.model.service;

import com.sapient.lesson.model.beans.User;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static Map<Integer, User> userList = new HashMap<Integer, User>();
    private static int idCounter = 1;

    public User createUser(String name, LocalDate dob) {
        User user = new User();
        user.setName(name);
        user.setDob(dob);
        user.setUserId(idCounter);
        idCounter++;
        userList.put(user.getUserId(), user);
        return user;
    }

    public User getUser(int userId) {
        return userList.get(userId);
    }

    public User updateUser(int userId, String newName) {
        try {
            User user = userList.get(userId);
            user.setName(newName);
            return user;
        }
        catch (Exception e) {
            return null;
        }
    }

    public User updateUser(int userId, LocalDate newDob) {
        try {
            User user = userList.get(userId);
            user.setDob(newDob);
            return user;
        }
        catch (Exception e) {
            return null;
        }
    }

    public void deleteUser(int userId) {
        try {
            userList.remove(userId);
        }
        catch (Exception e) { }
    }

    public User[] getAllUsers() {
        return userList.values().toArray(new User[0]);
    }
}
