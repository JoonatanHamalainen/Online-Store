package onlineStore.service;


import java.util.UUID;
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
    
    public User getUserByUserID(String username) {
        return dao.selectUserByUserName(username);
    }
    
    public int addUser(User user){
        System.out.println("lolleoel");
        return dao.insertUser(user);
    }
    
}
