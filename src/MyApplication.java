import Dao.ClassesDao;
import Dao.TaDao;
import Dao.UserDao;
import Rest.ClassesRO;
import Rest.TaRO;
import Rest.UserRO;
import Service.TaService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"Dao","Rest","Service"})
public class MyApplication {

    @Autowired
    private ClassesRO classesRO;

    @Autowired
    private ClassesDao classesDao;

    public void testDataPersist(){
      classesRO.setClassId("1");
      classesDao.removeClass(classesRO);

    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyApplication.class);
        MyApplication m1 = context.getBean(MyApplication.class);
        m1.testDataPersist();
    }

}
