package bau.petinder.model;

public class DashboardModel {

	private int petCount;
    private String activeLanguageCode;

    public int getPetCount() {
        return petCount;
    }

    public void setPetCount(int petCount) {
        this.petCount = petCount;
    }

    public String getActiveLanguageCode() {
        return activeLanguageCode;
    }

    public void setActiveLanguageCode(String activeLanguageCode) {
        this.activeLanguageCode = activeLanguageCode;
    }
}
