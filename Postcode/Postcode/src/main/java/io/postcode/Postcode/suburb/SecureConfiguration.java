package io.postcode.Postcode.suburb;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true, 
jsr250Enabled = true)

public class SecureConfiguration extends WebSecurityConfiguration{

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/suburbs/createSuburbs").hasRole("Editor")
            .antMatchers("/suburbs/**").hasRole("Viewer")
            .anyRequest().authenticated()
            .and().httpBasic();
          
    }

    public SecureConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

     
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails editorUser = User.withUsername("editor").password(passwordEncoder().encode("password"))
                .roles("Editor").build();
        UserDetails viewerUser = User.withUsername("viewer").password(passwordEncoder().encode("password"))
                .roles("Viewer").build();
        return new InMemoryUserDetailsManager(editorUser, viewerUser);
    }

}
