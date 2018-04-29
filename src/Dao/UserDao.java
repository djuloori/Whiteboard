package Dao;

import Model.UserEO;
import Rest.UserRO;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class UserDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public String findUser(UserRO userRO){
        em.getTransaction().begin();
        Query q = em.createNamedQuery("UserEntity.Validation", UserEO.class);
        String hashed_password = getMD5(userRO.getPassword());
        q.setParameter("username",userRO.getUsername());
        q.setParameter("password",hashed_password);
        em.getTransaction().commit();
        UserEO un;
        try {
            un = (UserEO) q.getSingleResult();
            if(userRO.getUsername().equals(un.getUsername()) && hashed_password.equals(un.getPassword())){
                return un.getUsertype();
            }else{
                return "failed";
            }
        }catch(Exception e){
            return "failed";
        }
    }

    public String createUser(UserRO userRO){
        UserEO user = new UserEO();
        user.setUsername(userRO.getUsername());
        String hashed_password = getMD5(userRO.getPassword());
        user.setPassword(hashed_password);
        user.setUsertype(userRO.getUsertype());
        em.getTransaction().begin();
        em.persist(user);
        try {
            em.getTransaction().commit();
            return "Success";
        }catch (Exception e){
            return "failed";
        }
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
