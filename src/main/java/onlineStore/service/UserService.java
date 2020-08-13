package onlineStore.service;


import onlineStore.dao.IUserDao;
import onlineStore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUserDao dao;
    
    @Autowired
    public UserService(@Qualifier("user") IUserDao dao) {
        this.dao = dao;
    }
    
    public User getUserByUsername(String username) {
        return dao.selectUserByUsername(username);
    }
    
    public int addUser(User user){
        return dao.insertUser(user);
    }
    
    public int addAdminIntoUserRoles(String username, int role) {
        return dao.insertUsersRoleIntoUserRoles(username, role);
    }
    
}
