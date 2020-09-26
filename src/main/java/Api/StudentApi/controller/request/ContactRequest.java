package Api.StudentApi.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ContactRequest {

    private String email;
    @JsonProperty("telephones")
    private List<TelephoneRequest> telephones;

    public List<TelephoneRequest> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneRequest> telephones) {
        this.telephones = telephones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
