package onlineStore.model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private final UUID userID;
	private final String gender, phone, username, fullname, password, email, address;
	private final Date birthdate;
	
	public User(@JsonProperty("userID") UUID userID, @JsonProperty("gender") String gender, @JsonProperty("phone") String phone, @JsonProperty("username") String username, @JsonProperty("fullname") String fullname, @JsonProperty("password") String password,
			@JsonProperty("email") String email, @JsonProperty("address") String address, @JsonProperty("birthdate") Date birthdate) {
		this.userID = userID;
		this.gender = gender;
		this.phone = phone;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.address = address;
		this.birthdate = birthdate;
	}

	public UUID getUserID() {
		return userID;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthdate() {
		return birthdate;
	}
}
