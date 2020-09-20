package Api.StudentApi.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentResponse {

    private Long id;
    private String name;
    private String surname;
    @JsonProperty("contact")
    private ContactResponse contact;

    public ContactResponse getContact() {
        return contact;
    }

    public void setContact(ContactResponse contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
