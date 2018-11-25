package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.UserEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;

@Component
public class UserDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public String findUser(UserEO user){
        try {
            Query query = m_SecurableEntityManager.createQuery("UserEntity.Validation", UserEO.class);
            query.setParameter("username",user.getUsername());
            query.setParameter("password",user.getPassword());
            UserEO userEO = (UserEO) query.getSingleResult();
            if(userEO.getUsername().equals(user.getUsername()) && userEO.getPassword().equals(user.getPassword())){
                return userEO.getUserType();
            }else{
                return "failed";
            }
        }catch(Exception e){
            return "failed";
        }
    }

    @Transactional
    public String createUser(UserEO user){
        try {
            m_SecurableEntityManager.save(user);
            return "Success";
        }catch (Exception e){
            return "failed";
        }
    }

}
