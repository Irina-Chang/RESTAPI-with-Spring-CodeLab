package codelab.spring.springboot2.config;

import codelab.spring.springboot2.service.CodeLabUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("rawtypes")

@EnableWebSecurity
@Log4j2
@EnableGlobalAuthentication
@RequiredArgsConstructor
@Configuration
public abstract class SecurityConfig implements WebSecurityConfigurer {

    private final CodeLabUserDetailsService codeLabUserDetailsService;

@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                //                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .authorizeHttpRequests()
                .requestMatchers("/animes/admin/**").hasRole("ADMIN")
                .requestMatchers("/animes/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("academy"));

        auth.inMemoryAuthentication()
                .withUser("usuario2")
                .password(passwordEncoder.encode("codelab"))
                .roles("USER","ADMIN")
                .and()
                .withUser("admin2")
                .password(passwordEncoder.encode("codelab"))
                .roles("USER");

        auth.userDetailsService(codeLabUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }


}