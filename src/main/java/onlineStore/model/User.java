package onlineStore.model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class User {

    private UUID userID;
    private String gender, phone, username, fullname, password, email, address;
    private boolean enabled;
    private List<String> roles;

    public boolean isEnabled() {
        return enabled;
    }

    private Date birthdate;

    public User(@JsonProperty("userID") UUID userID, @JsonProperty("gender") String gender, @JsonProperty("phone") String phone,
            @JsonProperty("username") String username, @JsonProperty("fullname") String fullname, @JsonProperty("password") String password,
            @JsonProperty("email") String email, @JsonProperty("address") String address, @JsonProperty("birthdate") Date birthdate,
            @JsonProperty("enabled") boolean enabled, @JsonProperty("roles") List<String> roles
    ) {
        this.userID = userID;
        this.gender = gender;
        this.phone = phone;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.enabled = enabled;
        this.roles = roles;

    }

    public List<String> getRoleList() {
        return roles;
    }

    public User() {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
