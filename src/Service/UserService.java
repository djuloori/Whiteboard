package Service;


import Dao.UserDao;
import Rest.UserRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

}
