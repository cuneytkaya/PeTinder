package bau.petinder.model;

import jakarta.validation.constraints.Size;

public class LoginModel {

	@Size(min = 3, max = 50, message = "{validation.mail.size}")
	private String mail;
	
	@Size(min = 3, max = 50, message = "{validation.password.size}")
	private String password;
	
	private boolean hasError;

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
	
	public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
