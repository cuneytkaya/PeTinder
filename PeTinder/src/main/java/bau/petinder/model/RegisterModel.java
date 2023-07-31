package bau.petinder.model;

import jakarta.validation.constraints.Size;

public class RegisterModel {
	
	@Size(min = 3, max = 50 , message = "{validation.register.firstName.size}")
    private String firstName;
    
	@Size(min = 3, max = 50 , message = "{validation.register.lastName.size}")
    private String lastName;
    
	@Size(min = 3, max = 50 , message = "{validation.register.email.size}")
    private String email;
    
	@Size(min = 0, max = 50 , message = "{validation.register.phone.size}")
    private String phone;
    
    private String additionalInformation;
    
    @Size(min = 3, max = 50 , message = "{validation.register.password.size}")
    private String password;

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

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
