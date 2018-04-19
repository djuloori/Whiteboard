import Dao.ClassesDao;
import Rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"Dao","Rest"})
public class MyApplication {

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private ClassesRO classesRO;

    public void testDataPersist(String[] args){
      classesRO.setClassId("aaaccaa");
      classesRO.setClassName("dddd");
      classesDao.addClass(classesRO);
    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyApplication.class);
        MyApplication m1 = context.getBean(MyApplication.class);
        m1.testDataPersist(args);
    }




}
