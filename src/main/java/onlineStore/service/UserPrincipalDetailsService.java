/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.service;


import java.util.Optional;
import onlineStore.dao.UserDao;
import onlineStore.model.User;
import onlineStore.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pate
 */
@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    
    private final UserDao userDao;

    @Autowired
    public UserPrincipalDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }
   
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
        User user = this.userDao.selectUserByUsername(string);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        
        return userPrincipal;
    }
    
}
