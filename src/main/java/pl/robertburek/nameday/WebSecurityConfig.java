package pl.robertburek.nameday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
@Slf4j

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Admin")
                .password(passwordEncoder().encode("Admin"))
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/loginOpenID")
//                .authenticated();

//            http
//                    .authorizeRequests()
//                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//                    .permitAll()
////                    .anyRequest().authenticated()
//                    .antMatchers("/nameDay/save").authenticated()
//                    .antMatchers("/nameDay/save/edit").authenticated()
//                    .antMatchers("/nameDay/del").authenticated()
//                    .antMatchers("/nameDayRest/save").authenticated()
//                    .antMatchers("/nameDayRest/delete").authenticated()
//                    .antMatchers("/loginOpenID").authenticated()
//                    .and()
//                    .oauth2Login()
//                    .loginPage("/login")
//                    .permitAll();
//            log.info(PathRequest.toStaticResources().atCommonLocations().toString());


        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/nameDay/save").authenticated()
                .antMatchers("/nameDay/save/edit").authenticated()
                .antMatchers("/nameDay/del").authenticated()
                .antMatchers("/nameDayRest/save").authenticated()
                .antMatchers("/nameDayRest/delete").authenticated()
                .antMatchers("/loginOpenID").authenticated()
                .and()
                .formLogin()
                .loginPage("/login");
    }

}
