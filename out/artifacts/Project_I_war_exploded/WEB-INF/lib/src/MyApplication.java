import Dao.ClassesDao;
import Rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"Dao","Rest"})
@Configuration
public class MyApplication {

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private ClassesRO classesRO;

    public void testDataPersist(){
      classesRO.setClassId("aaa");
      classesRO.setClassName("dddd");
      classesDao.addClass(classesRO);
    }

    public static void main(String[] args){
        MyApplication m1 = new MyApplication();
        m1.testDataPersist();
    }




}
