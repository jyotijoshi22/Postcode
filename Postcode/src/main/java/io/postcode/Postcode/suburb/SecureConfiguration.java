package io.postcode.Postcode.suburb;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity

public class SecureConfiguration {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.antMatchers("/suburbs/createSuburbs").hasRole("Editor");
                    auth.antMatchers("/suburbs/**").hasAnyRole("Editor", "Viewer");
                })
                .httpBasic(withDefaults())
                .build();
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
