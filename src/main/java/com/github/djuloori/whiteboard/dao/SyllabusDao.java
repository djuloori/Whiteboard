package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.SyllabusEO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class SyllabusDao extends AbstractDao{

    @Transactional
    public List getAllSyllubus(){
        Query query = createQuery("SyllabusEntity.findAll", SyllabusEO.class);;
        List<SyllabusEO> syllabusList = query.getResultList();
        return syllabusList;
    }

    @Transactional
    public String addsyllubus(String class_id, InputStream inputStream, String syllabusid) throws IOException {
        try {
            SyllabusEO syllabus = new SyllabusEO();
            syllabus.setClassId(class_id);
            syllabus.setIdsyllabus(syllabusid);
            syllabus.setSyllabus(org.apache.commons.io.IOUtils.toByteArray(inputStream));
            save(syllabus);
            return "done";
        }catch (Exception e){
            return "not done";
        }
    }

    @Transactional
    public String removeSyllabus(String syllabus_id){
        try {
            delete(SyllabusEO.class,syllabus_id);
            return "Syllabus Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}