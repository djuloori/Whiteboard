package Dao;

import Model.UserEO;
import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public String findUser(String username, String password){
        em.getTransaction().begin();
        Query q = em.createNamedQuery("UserEntity.Validation", UserEO.class);
        String hashed_password = getMD5(password);
        q.setParameter("username",username);
        q.setParameter("password",hashed_password);
        em.getTransaction().commit();
        UserEO un;
        try {
            un = (UserEO) q.getSingleResult();
            em.close();
            emf.close();
            if(username.equals(un.getUsername()) && hashed_password.equals(un.getPassword())){
                return un.getUsertype();
            }else{
                return "failed";
            }
        }catch(Exception e){
            return "failed";
        }
    }

    public String createUser(String username, String password, String usertype){
        UserEO user = new UserEO();
        user.setUsername(username);
        String hashed_password = getMD5(password);
        user.setPassword(hashed_password);
        user.setUsertype(usertype);
        em.getTransaction().begin();
        em.persist(user);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
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
