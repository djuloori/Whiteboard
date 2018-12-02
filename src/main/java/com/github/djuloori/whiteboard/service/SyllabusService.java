package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.SyllabusDao;
import com.github.djuloori.whiteboard.model.SyllabusEO;
import com.github.djuloori.whiteboard.rest.SyllabusRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

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

}
