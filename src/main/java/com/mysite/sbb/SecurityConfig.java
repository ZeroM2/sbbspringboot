package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //스프링의 환경설정 파일임을 의미하는 에너테이션
@EnableWebSecurity // 모든 요청URL이 스프링 시큐리티의 제어를 받도록 하는 에너테이션
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //모든 인증되지 않은 요청은 허락한다. 로그인을 하지 않더라도 페이지에 접근가
        http.authorizeRequests().antMatchers("/**").permitAll()


                //.and()//http 객체의 설정을 이어허 할 수 있게 하는 메서드
               // .csrf().ignoringAntMatchers("/h2-console/**"); //h2-console로 시작하는 URl은 CSRF 검정을 하지 않는다는 설정
        ;
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
