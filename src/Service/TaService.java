package Service;

import Dao.TaDao;
import Rest.TaRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaService {

    @Autowired
    private TaDao taDao;


    public String syncTa(TaRO taRO){
        return taDao.addTa(taRO);
    }

    public String removeTa(String id){
        return taDao.removeTa(id);
    }

}
