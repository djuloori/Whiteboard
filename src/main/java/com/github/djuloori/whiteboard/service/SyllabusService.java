package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.SyllabusDao;
import com.github.djuloori.whiteboard.model.SyllabusEO;
import com.github.djuloori.whiteboard.rest.SyllabusRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class SyllabusService {

  @Autowired
  private SyllabusDao syllabusDao;

  public String syncSyllabus(String classId, InputStream inputStream, String syllabusId) throws IOException {
    SyllabusEO syllabus = new SyllabusEO();
    syllabus.setClassId(classId);
    syllabus.setSyllabusId(syllabusId);
    syllabus.setSyllabus(org.apache.commons.io.IOUtils.toByteArray(inputStream));
    return syllabusDao.addsyllubus(syllabus);
  }

  public String removeSyllabus(String syllabusId){
    return syllabusDao.removeSyllabus(syllabusId);
  }

  public List viewSyllabus(){
     List<SyllabusEO> syllabusList = syllabusDao.getAllSyllubus();
     List<SyllabusRO> syllabus = new ArrayList<>();
     for(SyllabusEO syllabusEO: syllabusList){
         SyllabusRO syllabusRO = new SyllabusRO();
         syllabusRO.setIdsyllabus(syllabusEO.getSyllabusId());
         syllabusRO.setCLASS_ID(syllabusEO.getClassId());
         syllabusRO.setSyllabus(syllabusEO.getSyllabus());
         syllabus.add(syllabusRO);
     }
     return syllabus;
  }

}
