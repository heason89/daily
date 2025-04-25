//package com.example.daily.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//// @Configuration 表示設定類別，spring 會將他視為設定檔
//@Configuration
//// @EnableWebSecurity 啟用 Spring Security 的網頁安全功能。
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    // 設定 Spring Security 的過濾器鏈（Filter Chain)
//    // 其功能有 驗證使用者身份 處理登入/登出 權限檢查 防止 CSRF 攻擊
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // 設定請求授權規則
//        // requestMatchers("/", "/oauth2/**").permitAll()：表示允許所有人（不需登入）訪問 / 和 /oauth2/ 路徑
//        // .with(...)：是新版 Spring Security 中設定附加配置的方法
//        // new OAuth2LoginConfigurer<HttpSecurity>() 表示設定 OAuth2 登入的配置。
//        // defaultSuccessUrl("/welcome", true) 表示登入成功後導向 /welcome 頁面。
//        // defaultSuccessUrl("/welcome", true) true 表示無論原本請求的是哪個 URL，成功登入後一律導向 /welcome。
//        // http.build(); 表示建立這個安全設定的 filter chain
//        http.authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/", "/oauth2/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .with(new OAuth2LoginConfigurer<HttpSecurity>(),
//                        oauth2 ->
//                                oauth2.defaultSuccessUrl("/welcome", false));
//        return http.build();
//    }
//}
