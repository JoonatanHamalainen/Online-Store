package onlineStore.api;


import javax.validation.Valid;
import onlineStore.model.User;
import onlineStore.model.UserRoles;
import onlineStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/admin")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{name}")
    public User getUserByUsername(@PathVariable("name") String name) {
        return userService.getUserByUsername(name);              
    }
    
    @PostMapping("/userRoles")
    public int addAdminIntoUserRoles (@Valid @NonNull @RequestBody UserRoles userRoles){
        return userService.addAdminIntoUserRoles(userRoles.getUsername(), userRoles.getRoleid());
    }
    
    
    

}
