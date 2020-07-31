/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Pate
 */
public class UserRoles {
    
    private final String username;
    private final int roleid;

    public UserRoles(@JsonProperty("username") String username, @JsonProperty("roleid") int roleid) {
        this.username = username;
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public int getRoleid() {
        return roleid;
    }

    
    
    
}
