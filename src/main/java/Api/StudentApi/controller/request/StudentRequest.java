package Api.StudentApi.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StudentRequest {

    private String name;
    private String surname;
    @JsonProperty("contact")
    private ContactRequest contactRequest;
    @JsonProperty("subjects")
    private List<SubjectRequest> subjects;

    public List<SubjectRequest> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectRequest> subjects) {
        this.subjects = subjects;
    }

    public ContactRequest getContactRequest() {
        return contactRequest;
    }

    public void setContactRequest(ContactRequest contactRequest) {
        this.contactRequest = contactRequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
