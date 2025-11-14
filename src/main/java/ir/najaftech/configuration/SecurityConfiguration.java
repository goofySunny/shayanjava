package ir.najaftech.configuration;


import ir.najaftech.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = createUser("sunBun", "123");
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                auth -> {
                    auth.requestMatchers("/admin/*").authenticated()
                            .requestMatchers("/admin").authenticated()
                            .anyRequest().permitAll();
                }
        )
                .formLogin(form -> {
                    form.loginPage("/login")
                        .permitAll();
                })
                .exceptionHandling(ex -> {
                    ex.accessDeniedPage("/403");
                })
                .csrf(csrf -> csrf.disable())
                .headers(header -> header.frameOptions(t -> t.sameOrigin()));
        return http.build();
    }

    private UserDetails createUser(String userName, String password) {
        return Customer.builder()
                .email(userName)
                .name(userName)
                .password(passwordEncoder().encode(password))
                .build();
    }

}
