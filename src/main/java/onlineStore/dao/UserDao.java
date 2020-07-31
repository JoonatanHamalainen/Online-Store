/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import onlineStore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pate
 */
@Repository("user")
public class UserDao implements IUserDao {

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User selectUserByUsername(String userName) {
        final String sql = "SELECT roles.name"
                + " FROM users "
                + " INNER JOIN userroles ON userroles.username = users.username "
                + " INNER JOIN roles ON userroles.roleid = roles.roleid WHERE users.username = ?";

        //Käyttäjän kaikki roolinimet listana
        List<String> roles = jdbcTemplate.query(sql, new Object[]{userName}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            return name;
        });

        final String sql2 = "SELECT userid, gender, phone, username, fullname, userpassword, email, birthdate, address, enabled "
                + "FROM users WHERE username = ?";

        User user = jdbcTemplate.queryForObject(sql2, new Object[]{userName}, (resultSet, i) -> {
            UUID userID = UUID.fromString(resultSet.getString("userid"));
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            String username = resultSet.getString("username");
            String fullname = resultSet.getString("fullname");
            String userpassword = resultSet.getString("userpassword");
            String email = resultSet.getString("email");
            Date date = resultSet.getDate("birthdate");
            String address = resultSet.getString("address");
            boolean enabled = resultSet.getBoolean("enabled");
            return new User(userID, gender, phone, username, fullname, userpassword, email, address, date, enabled, roles);

        });

        return user;
    }

    @Override
    public int insertUser(UUID id, User user) {
        final String sql = "INSERT INTO users (userid, gender, phone, username, fullname, userpassword, email,"
                + " birthdate, address, enabled) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        
        jdbcTemplate.update(sql, id, user.getGender(), user.getPhone(), user.getUsername(),
                user.getFullname(), encodedPassword, user.getEmail(), user.getBirthdate(), user.getAddress(), user.isEnabled());
        
        return insertUsersRoleIntoUserRoles(user.getUsername(), 2);
    }

    @Override
    public int insertUsersRoleIntoUserRoles(String username, int role) {
        final String sql = "INSERT INTO userroles (username, roleid)"
                + "VALUES (?, ?)";
        
        return jdbcTemplate.update(sql, username, role);   
    }
    
    



}
