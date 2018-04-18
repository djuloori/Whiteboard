import Dao.ClassesDao;
import Rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

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
