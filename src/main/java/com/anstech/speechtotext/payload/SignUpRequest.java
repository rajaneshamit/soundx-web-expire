package com.anstech.speechtotext.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

	  @NotBlank
	  //  @Size(min = 4, max = 40)
	    private String name;

	    @NotBlank
	  //  @Size(min = 3, max = 15)
	    private String username;

	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;

	    @NotBlank
	   // @Size(min = 3, max = 20)
	    private String password;
	    
	    @NotBlank
	    @Size(max = 30)
	    private String mobile;
	    
	    @NotBlank
	    private String role;
	    
	    @NotBlank
	    private String active;
	    
	    private String address;

	    public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}	
}
