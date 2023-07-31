package bau.petinder.model;

public class CustomerOverviewModel {
    private String fullName;
    private String email;
    private String phone;
    private String additionalInformation;
    private boolean isAdmin;
    private int petCount;

    public int getPetCount() {
        return petCount;
    }

    public void setPetCount(int petCount) {
        this.petCount = petCount;
    }
    
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
    
    private String activeLanguageCode;

    public String getActiveLanguageCode() {
        return activeLanguageCode;
    }

    public void setActiveLanguageCode(String activeLanguageCode) {
        this.activeLanguageCode = activeLanguageCode;
    }
}

