package bau.petinder.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Pet extends BaseEntity {
	
	private int sourcePetId;

	public int getSourcePetId() {
	    return sourcePetId;
	}

	public void setSourcePetId(int sourcePetId) {
	    this.sourcePetId = sourcePetId;
	}
	
	@Size(min = 3, max = 50, message = "{validation.pet.size}")
    private String name;
	
	@Min(value = 1, message = "{validation.pet.type.size}")
    private int petTypeId;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    private boolean vaccinated;
    
    private String additionalInformation;
    
    private int customerId;
    
    @Size(min = 3, max = 50)
    private String petTypeName;

    public String getPetTypeName() {
        switch (petTypeId) {
            case 10:
                return petType.DOG.name();
            case 20:
                return petType.CAT.name();
            default:
                return null; // or a default value if needed
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

