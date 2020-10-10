package Api.StudentApi.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SubjectRequest {

    private String subject;
    @JsonProperty("students")
    private List<StudentRequest> students;

    public List<StudentRequest> getStudents() {
        return students;
    }

    public void setStudents(List<StudentRequest> students) {
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
