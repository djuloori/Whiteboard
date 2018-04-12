import Dao.UserDao;

public class App {
    public static void main(String[] args){
        UserDao userDao = new UserDao();
        userDao.createUser("TestUser1","123456","Professor");
    }
}
