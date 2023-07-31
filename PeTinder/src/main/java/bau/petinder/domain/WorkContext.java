package bau.petinder.domain;

public class WorkContext extends BaseEntity {

    private String activeLanguageCode;
    private int activeCustomerId;

    // Getter and Setter for activeLanguageCode
    public String getActiveLanguageCode() {
        return activeLanguageCode;
    }

    public void setActiveLanguageCode(String activeLanguageCode) {
        this.activeLanguageCode = activeLanguageCode;
    }

    // Getter and Setter for activeCustomerId
    public int getActiveCustomerId() {
        return activeCustomerId;
    }

    public void setActiveCustomerId(int activeCustomerId) {
        this.activeCustomerId = activeCustomerId;
    }
}
