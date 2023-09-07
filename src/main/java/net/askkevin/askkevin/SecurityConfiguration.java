package net.askkevin.askkevin;

import net.askkevin.askkevin.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true) // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page

                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login") // append a query string value

                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/",
                        "/profile", // only authenticated users can see their profile
                        "/profile/insurance", // only authenticated users can edit their insurance
                        "/profile/doctors", // only authenticated users can edit their doctors
                        "/profile/surgeries", // only authenticated users can edit their surgeries
                        "/profile/conditions", // only authenticated users can edit their conditions
                        "/profile/prescriptions" // only authenticated users can edit their prescriptions
                )
                .authenticated()

                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/register",  "/audio/**", "/css/**", "/img/**", "/js/**") // anyone can see the home and the posts pages
                .permitAll()
        ;
        return http.build();
    }

}

