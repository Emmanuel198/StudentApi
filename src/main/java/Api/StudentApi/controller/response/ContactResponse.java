package Api.StudentApi.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ContactResponse {
    private Long id;
    private String email;
    @JsonProperty("telephones")
    private List<TelephoneResponse> telephones;

    public List<TelephoneResponse> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneResponse> telephones) {
        this.telephones = telephones;
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
