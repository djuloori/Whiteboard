package com.github.djuloori.whiteboard.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class TaRO {

    private String taId;
    private String taName;
    private String taEmail;
    private String taPhone;
    private String taTimings;
    private String day;
    private String CLASS_ID;

    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getTaEmail() {
        return taEmail;
    }

    public void setTaEmail(String taEmail) {
        this.taEmail = taEmail;
    }

    public String getTaPhone() {
        return taPhone;
    }

    public void setTaPhone(String taPhone) {
        this.taPhone = taPhone;
    }

    public String getTaTimings() {
        return taTimings;
    }

    public void setTaTimings(String taTimings) {
        this.taTimings = taTimings;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(String CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }
}
