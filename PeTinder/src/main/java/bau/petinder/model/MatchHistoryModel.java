package bau.petinder.model;

import java.time.LocalDate;

import bau.petinder.domain.petType;

public class MatchHistoryModel extends BaseEntityModel {

	private boolean isMatchSelected;
    private String sourcePetName;
    private LocalDate targetDateOfBirth;
    private boolean targetVaccinated;
    private String targetAdditionalInformation;
    private int targetTypeId;
    private String targetCustomerName;
    private String targetCustomerEmail;
    private String targetCustomerPhone;
    private String targetCustomerAdditionalInformation;
    
    private String targetTypeName;
    
    private String targetPetName;

    public String getTargetPetName() {
        return targetPetName;
    }

    public void setTargetPetName(String targetPetName) {
        this.targetPetName = targetPetName;
    }
    
    public boolean isMatchSelected() {
        return isMatchSelected;
    }

    public void setMatchSelected(boolean matchSelected) {
        isMatchSelected = matchSelected;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public String setTargetTypeName(String targetTypeName) {
    	switch (targetTypeId) {
        case 10:
            return petType.DOG.name();
        case 20:
            return petType.CAT.name();
        default:
            return null; // or a default value if needed
    }
    }

    public String getSourcePetName() {
        return sourcePetName;
    }

    public void setSourcePetName(String sourcePetName) {
        this.sourcePetName = sourcePetName;
    }

    public LocalDate getTargetDateOfBirth() {
        return targetDateOfBirth;
    }

    public void setTargetDateOfBirth(LocalDate targetDateOfBirth) {
        this.targetDateOfBirth = targetDateOfBirth;
    }

    public boolean isTargetVaccinated() {
        return targetVaccinated;
    }

    public void setTargetVaccinated(boolean targetVaccinated) {
        this.targetVaccinated = targetVaccinated;
    }

    public String getTargetAdditionalInformation() {
        return targetAdditionalInformation;
    }

    public void setTargetAdditionalInformation(String targetAdditionalInformation) {
        this.targetAdditionalInformation = targetAdditionalInformation;
    }

    public int getTargetTypeId() {
        return targetTypeId;
    }

    public void setTargetTypeId(int targetTypeId) {
        this.targetTypeId = targetTypeId;
    }

    public String getTargetCustomerName() {
        return targetCustomerName;
    }

    public void setTargetCustomerName(String targetCustomerName) {
        this.targetCustomerName = targetCustomerName;
    }

    public String getTargetCustomerEmail() {
        return targetCustomerEmail;
    }

    public void setTargetCustomerEmail(String targetCustomerEmail) {
        this.targetCustomerEmail = targetCustomerEmail;
    }

    public String getTargetCustomerPhone() {
        return targetCustomerPhone;
    }

    public void setTargetCustomerPhone(String targetCustomerPhone) {
        this.targetCustomerPhone = targetCustomerPhone;
    }

    public String getTargetCustomerAdditionalInformation() {
        return targetCustomerAdditionalInformation;
    }

    public void setTargetCustomerAdditionalInformation(String targetCustomerAdditionalInformation) {
        this.targetCustomerAdditionalInformation = targetCustomerAdditionalInformation;
    }
}
