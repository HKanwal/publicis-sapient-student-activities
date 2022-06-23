package com.sapient.dbexample.model.service;

import com.sapient.dbexample.exceptions.NonexistentUserException;
import com.sapient.dbexample.model.beans.User_;

import java.util.List;

public interface UserService {
    public User_ createUser(String name);
    public User_ fetchUser(int id) throws NonexistentUserException;
    public List<User_> fetchAllUsers();
    public User_ modifyUser(int id, String newName) throws NonexistentUserException;
    public void deleteUser(int id) throws NonexistentUserException;
}
