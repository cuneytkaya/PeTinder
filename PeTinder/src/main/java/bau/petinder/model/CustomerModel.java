package bau.petinder.model;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class CustomerModel extends BaseEntityModel {

	@Size(min = 3, max = 50)
    private String firstName;
    
    @Size(min = 3, max = 50)
    private String lastName;
    
    @Size(min = 3, max = 50)
    private String email;
    
    @Size(min = 3, max = 50)
    private String phone;
    
    private boolean active;
    
    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdOnUtc;
    
    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastLoginDateUtc;
    
    private boolean isAdmin;
    
    @Size(min = 3, max = 400)
    private String additionalInformation;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getCreatedOnUtc() {
        return createdOnUtc;
    }

    public void setCreatedOnUtc(LocalDate createdOnUtc) {
        this.createdOnUtc = createdOnUtc;
    }

    public LocalDate getLastLoginDateUtc() {
        return lastLoginDateUtc;
    }

    public void setLastLoginDateUtc(LocalDate lastLoginDateUtc) {
        this.lastLoginDateUtc = lastLoginDateUtc;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
	
}
