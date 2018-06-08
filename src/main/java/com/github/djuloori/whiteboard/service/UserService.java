package com.github.djuloori.whiteboard.service;


import com.github.djuloori.whiteboard.dao.UserDao;
import com.github.djuloori.whiteboard.rest.UserRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

   @Autowired
   private UserRO userRO;

   @Autowired
   private UserDao userDao;

   public String evaluateUser(UserRO userRO){
       return userDao.findUser(userRO);
   }

   public String syncUser(UserRO userRO){
       return userDao.createUser(userRO);
   }


    //ToDo - Might not need!
    /*private String issueToken(String username){
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        return token;
    }*/

}
