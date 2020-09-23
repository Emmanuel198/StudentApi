package Api.StudentApi.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactRequest {

    private String email;
    @JsonProperty("telephone")
    private TelephoneRequest telephone;

    public TelephoneRequest getTelephone() {
        return telephone;
    }

    public void setTelephone(TelephoneRequest telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
