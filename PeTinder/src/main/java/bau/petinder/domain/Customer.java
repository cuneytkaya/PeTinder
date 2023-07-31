package bau.petinder.domain;

import java.time.LocalDate;

public class Customer extends BaseEntity {
	
	private String FirstName;
	
	private String LastName;
	
	private String Email;
	
	private String Phone;
	
	private boolean Active;
	
	private LocalDate CreatedOnUtc;
	
	private LocalDate LastLoginDateUtc;
	
	private boolean IsAdmin;
	
	private String AdditionalInformation;
	
	private String Password;
	
	 public String getFirstName() {
	        return FirstName;
	    }
	    
	    public void setFirstName(String firstName) {
	        FirstName = firstName;
	    }
	    
	    public String getLastName() {
	        return LastName;
	    }
	    
	    public void setLastName(String lastName) {
	        LastName = lastName;
	    }
	    
	    public String getEmail() {
	        return Email;
	    }
	    
	    public void setEmail(String email) {
	        Email = email;
	    }
	    
	    public String getPhone() {
	        return Phone;
	    }
	    
	    public void setPhone(String phone) {
	        Phone = phone;
	    }
	    
	    public boolean isActive() {
	        return Active;
	    }
	    
	    public void setActive(boolean active) {
	        Active = active;
	    }
	    
	    public LocalDate getCreatedOnUtc() {
	        return CreatedOnUtc;
	    }
	    
	    public void setCreatedOnUtc(LocalDate date) {
	        CreatedOnUtc = date;
	    }
	    
	    public LocalDate getLastLoginDateUtc() {
	        return LastLoginDateUtc;
	    }
	    
	    public void setLastLoginDateUtc(LocalDate lastLoginDateUtc) {
	        LastLoginDateUtc = lastLoginDateUtc;
	    }
	    
	    public boolean isAdmin() {
	        return IsAdmin;
	    }
	    
	    public void setIsAdmin(boolean isAdmin) {
	        IsAdmin = isAdmin;
	    }
	    
	    public String getAdditionalInformation() {
	        return AdditionalInformation;
	    }
	    
	    public void setAdditionalInformation(String additionalInformation) {
	        AdditionalInformation = additionalInformation;
	    }
	    
	    public String getPassword() {
	        return Password;
	    }
	    
	    public void setPassword(String password) {
	        Password = password;
	    }
}
