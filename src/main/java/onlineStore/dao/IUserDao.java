package onlineStore.dao;

import java.util.UUID;
import onlineStore.model.User;

public interface IUserDao {

    int insertUser(UUID id, User user);
    
    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);

    }

    User selectUserByUsername(String userName);

    int insertUsersRoleIntoUserRoles(String username, int role);


}
