package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.SyllabusDao;
import com.github.djuloori.whiteboard.rest.SyllabusRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SyllabusService {

  @Autowired
  private SyllabusDao syllabusDao;

  @Autowired
  private SyllabusRO syllabusRO;


  //ToDo - Make use of RO's
  public String syncSyllabus(String class_id, InputStream inputStream, String syllabusid) throws IOException {
    return syllabusDao.addsyllubus(class_id,inputStream,syllabusid);
  }

  public String removeSyllabus(String syllabusid){
    return syllabusDao.removeSyllabus(syllabusid);
  }




}
