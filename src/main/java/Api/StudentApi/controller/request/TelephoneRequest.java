package Api.StudentApi.controller.request;

import Api.StudentApi.models.TelephoneType;

public class TelephoneRequest {

    private TelephoneType type;
    private String prefix;
    private String number;

    public TelephoneType getType() {
        return type;
    }

    public void setType(TelephoneType type) {
        this.type = type;
    }

    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
