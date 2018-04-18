package Rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SyllabusRO {

    private byte[] syllabus;
    private String idsyllabus;
    private String CLASS_ID;

    public byte[] getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(byte[] syllabus) {
        this.syllabus = syllabus;
    }

    public String getIdsyllabus() {
        return idsyllabus;
    }

    public void setIdsyllabus(String idsyllabus) {
        this.idsyllabus = idsyllabus;
    }

    public String getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(String CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }
}
