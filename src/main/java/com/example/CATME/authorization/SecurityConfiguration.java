package com.example.CATME.authorization;

import com.example.CATME.DatabaseConfiguration.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    DataSource dataSource = dataSourceConfig.getDataSource();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");

        dataSource.getConnection().close();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        //return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/instructor").hasAnyRole("ADMIN", "INSTRUCTOR")
                .antMatchers("/home").hasAnyRole("ADMIN", "TA")
                .antMatchers("/").hasAnyRole("ADMIN", "INSTRUCTOR", "TA", "STUDENT", "GUEST")
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login").defaultSuccessUrl("/", true);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resetPassword").antMatchers("/logout");
    }
}
