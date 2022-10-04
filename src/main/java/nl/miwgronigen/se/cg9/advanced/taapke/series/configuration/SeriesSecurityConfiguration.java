package nl.miwgronigen.se.cg9.advanced.taapke.series.configuration;

import nl.miwgronigen.se.cg9.advanced.taapke.series.service.SeriesUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Configuration
public class SeriesSecurityConfiguration {

    final SeriesUserDetailService seriesUserDetailService;

    public SeriesSecurityConfiguration(SeriesUserDetailService seriesUserDetailService) {
        this.seriesUserDetailService = seriesUserDetailService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize)-> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/", "/series/overview").permitAll()
                        .anyRequest().authenticated()
        ).formLogin().and()
                .logout().logoutSuccessUrl("/series/overview");
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(seriesUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
                return authenticationProvider;
    }
}
