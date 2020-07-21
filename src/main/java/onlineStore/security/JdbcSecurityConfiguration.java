/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineStore.security;

import onlineStore.datasource.PostgresDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Pate
 */
@EnableWebSecurity
public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PostgresDatasource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource.hikariDataSource())
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority "
                        + "FROM user_authorities a, users u "
                        + "WHERE u.username = ? "
                        + "AND u.id = a.user_id"
                );
    }
}
