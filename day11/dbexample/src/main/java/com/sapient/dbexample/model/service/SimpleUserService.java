package com.sapient.dbexample.model.service;

import com.sapient.dbexample.exceptions.NonexistentUserException;
import com.sapient.dbexample.model.beans.User_;
import com.sapient.dbexample.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleUserService implements UserService {
    @Autowired
    private UserRepository userDao;

    @Override
    public User_ createUser(String name) {
        User_ user = new User_();
        user.setName(name);
        userDao.save(user);
        return user;
    }

    @Override
    public User_ fetchUser(int id) throws NonexistentUserException {
        User_ user = userDao.findById(id).orElse(null);
        if (user == null) {
            throw new NonexistentUserException("User with id "+id+" not found.");
        }
        return user;
    }

    @Override
    public List<User_> fetchAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User_ modifyUser(int id, String newName) throws NonexistentUserException {
        User_ user;
        user = this.fetchUser(id);
        user.setName(newName);
        return user;
    }

    @Override
    public void deleteUser(int id) throws NonexistentUserException {
        this.fetchUser(id);
        userDao.deleteById(id);
    }
}
