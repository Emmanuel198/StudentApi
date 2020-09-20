package Api.StudentApi.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentRequest {

    private String name;
    private String surname;
    @JsonProperty("contact")
    private ContactRequest contactRequest;

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
