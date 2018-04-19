package Service;


import Dao.UserDao;
import Rest.UserRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"Dao","Rest"})
public class UserService {

   @Autowired
   private UserRO userRO;

   @Autowired
   private UserDao userDao;

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
