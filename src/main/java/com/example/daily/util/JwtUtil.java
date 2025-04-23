package com.example.daily.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // JWT 分成三個部分 Header 、 Payload (Claims) 、Signature
    // Header 說明用什麼演算法加密
    // Payload	也就是 Claims，放你想塞的資料
    // Signature 加密簽章，確保資料沒被改過

    // Payload 裡包含的欄位有 sub、exp、iat
    // sub 放 使用者ID、Email 等
    // exp 放 token 的過期時間
    // iat 放  token 的建立時間(什麼時候簽的)

    // 產生 JWT 的加密簽章用「金鑰（Key）」
    // Keys.secretKeyFor 用來產生一組「適合 JWT 使用的安全金鑰」。
    // SignatureAlgorithm.HS256 代表 HMAC-SHA25 對稱加密簽章方式
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 建議改成從設定檔讀取

    // 註冊產生驗證碼用
    public String generateVerificationToken(String email) {
        int expirationMillis = 1000 * 60 * 60; // 60 分鐘
        // Jwts.builder() 代表建立一個新的 JWT
        // setSubject() 代表 token 的主體，主要設定信箱用(收件者)
        // setIssuedAt() 代表 token 被建立的時間
        // setExpiration() 代表 token 的過期時間
        // signWith(key) 代表用你產生好的「金鑰（Key）」來簽名 token ，防止被竄改
        // compact() 代表把整個 Token 編碼成一個字串（JWT 字串）
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    // 驗證 JWT，並拿出裡面的使用者身份（Email）
    public String extractEmail(String token) {
        // 解析 JWT Token 並取得裡面的使用者資訊
        // Jwts.parserBuilder() 代表建立一個 JWT 的解析器
        // setSigningKey(key) 設定用來驗證 JWT 簽章的「金鑰」
        // build() 建立出實際的 Parser 實例
        // parseClaimsJws(token) 將你的 JWT 字串傳進來進行解析，同時會驗證簽章是否合法、token 是否過期等
        // getBody() 拿出解析後的 Claims （token 裡的資料 payload）
        // getSubject() 從 Claims 裡拿出 sub 欄位(也就是你產生 token 時 setSubject(...) 放的 email)
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    // 驗證 JWT
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    // 重設密碼產生驗證碼用
    public String generateResetPasswordToken(String email) {
        int expirationMillis = 1000 * 60 * 30; // 30 分鐘
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }
}
