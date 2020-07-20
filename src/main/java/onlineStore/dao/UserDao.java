/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.dao;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import onlineStore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pate
 */
@Repository("user")
public class UserDao implements IUserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User selectUserByUserID(UUID ID) {
        final String sql = "SELECT roles.name"
                + " FROM users "
                + " INNER JOIN userroles ON userroles.userid = users.userid "
                + " INNER JOIN roles ON userroles.roleid = roles.roleid WHERE users.userid = ?";

        //Käyttäjän kaikki roolinimet listana
        List<String> roles = jdbcTemplate.query(sql, new Object[]{ID}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            return name;
        });

        final String sql2 = "SELECT userid, gender, phone, username, fullname, userpassword, email, birthdate, address "
                + "FROM users WHERE userid = ?";

        User user = jdbcTemplate.queryForObject(sql2, new Object[]{ID}, (resultSet, i) -> {
            UUID userID = UUID.fromString(resultSet.getString("userid"));
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            String username = resultSet.getString("username");
            String fullname = resultSet.getString("fullname");
            String userpassword = resultSet.getString("userpassword");
            String email = resultSet.getString("email");
            Date date = resultSet.getDate("birthdate");
            String address = resultSet.getString("address");
            return new User(userID, gender, phone, username, fullname, userpassword, email, address, date, roles);

        });

        return user;
    }

    @Override
    public User selectUserByUserName(String userName) {
        final String sql = "SELECT userid FROM users WHERE username = ?";

        UUID userID = jdbcTemplate.queryForObject(sql, new Object[]{userName}, (resultSet, i) -> {
            return UUID.fromString(resultSet.getString("userid"));
        });

        User user = selectUserByUserID(userID);
        
        return user;
    }

}
