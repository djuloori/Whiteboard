package Service;


import Dao.UserDao;
import Rest.UserRO;

public class UserService {
   UserRO userRO = new UserRO();

   UserDao userDao = new UserDao();

   public String evaluateUser(String username, String Password){
       userRO.setUsername(username);
       userRO.setPassword(Password);
       return userDao.findUser(userRO);
   }

   public String syncUser(String username, String Password, String usertype){
       userRO.setUsername(username);
       userRO.setPassword(Password);
       userRO.setUsertype(usertype);
       return userDao.createUser(userRO);
   }

}
