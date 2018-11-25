package com.github.djuloori.whiteboard.service;


import com.github.djuloori.whiteboard.dao.UserDao;
import com.github.djuloori.whiteboard.framework.PasswordEncryptor;
import com.github.djuloori.whiteboard.model.UserEO;
import com.github.djuloori.whiteboard.rest.UserRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class UserService {

   @Autowired
   private UserDao userDao;

   public String evaluateUser(UserRO userRO){
       UserEO user = new UserEO();
       user.setUsername(userRO.getUsername());
       user.setPassword(PasswordEncryptor.Encrypt(userRO.getPassword()));
       return userDao.findUser(user);
   }

   public String syncUser(UserRO userRO){
       UserEO user = new UserEO();
       user.setUsername(userRO.getUsername());
       user.setPassword(PasswordEncryptor.Encrypt(userRO.getPassword()));
       user.setUserType(userRO.getUsertype());
       return userDao.createUser(user);
   }

}
