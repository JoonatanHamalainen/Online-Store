package onlineStore.dao;


import java.util.UUID;
import onlineStore.model.User;

public interface IUserDao {
    
    User selectUserByUserName(String userName);
    User selectUserByUserID(UUID userID);
    
}
