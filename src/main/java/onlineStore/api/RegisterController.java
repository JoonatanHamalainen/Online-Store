/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.api;

import javax.validation.Valid;
import onlineStore.model.User;
import onlineStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pate
 */
@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("api/v1/register")
    public void addUser(@Valid @NonNull @RequestBody User user) {
        System.out.println("lol");
        userService.addUser(user);
    }

}
