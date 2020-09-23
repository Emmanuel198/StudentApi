package Api.StudentApi.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactResponse {
    private Long id;
    private String email;
    @JsonProperty("telephone")
    private TelephoneResponse telephone;

    public TelephoneResponse getTelephone() {
        return telephone;
    }

    public void setTelephone(TelephoneResponse telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
