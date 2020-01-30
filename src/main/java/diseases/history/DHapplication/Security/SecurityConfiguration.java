package diseases.history.DHapplication.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.requiresChannel()
                .anyRequest()
                .requiresSecure()
                .and().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/doctor").hasRole("DOCTOR")
                .antMatchers("/api/visit").hasRole("DOCTOR")
                .antMatchers("/api/patient").hasAnyRole("REGISTRANT", "DOCTOR")
                .antMatchers("/patient").hasRole("PATIENT")
                .antMatchers("/registrant").hasRole("REGISTRANT")
                .and().rememberMe()
                .rememberMeCookieName("username")
                .and().formLogin();


    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
