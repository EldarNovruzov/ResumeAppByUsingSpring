/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.impl.UserRepositoryCustom;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @PersistenceContext
    EntityManager em;

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityIdbyRequest) {
        return userDao.getAll(name,surname,nationalityIdbyRequest);
    }

    @Override//CRITERIA BUILDER
    public User findbyEmailandPassword(String email, String password) {
        return userDao.findbyEmailandPassword(email,password);
    }

//
    @Override//WITH NAMED QUERY
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }


    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao.removeUser(id);
    }

    @Override
    public User getbyID(int userId) {
        return userDao.getbyID(userId);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

}
