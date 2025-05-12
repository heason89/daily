package com.example.daily.util;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SecretDao;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.Secret;
import com.example.daily.entity.User;
import com.example.daily.vo.ExtractEmailTokenRes;
import com.example.daily.vo.ExtractUserTokenRes;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    private SecretDao secretDao;

    @Autowired
    private UserDao userDao;

    // JWT 分成三個部分 Header 、 Payload (Claims) 、Signature
    // Header 說明用什麼演算法加密
    // Payload	也就是 Claims，放你想塞的資料
    // Signature 加密簽章，確保資料沒被改過

    // Payload 裡包含的欄位有 sub、exp、iat
    // sub 放 使用者ID、Email 等
    // exp 放 token 的過期時間
    // iat 放  token 的建立時間(什麼時候簽的)

    // 產生註冊驗證碼
    public String generateRegisterToken(String email) {
        Secret secret = getSecret();
        String emailSecret = secret.getEmailSecret();
        Key emailKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(emailSecret));
        int expirationMillis = 1000 * 60 * 30; // 30 分鐘
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
                .signWith(emailKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 驗證 JWT 是否過期，並拿出裡面的 Email
    public ExtractEmailTokenRes extractEmailToken(String token) {
        try {
            Secret secret = getSecret();
            String emailSecret = secret.getEmailSecret();
            Key emailKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(emailSecret));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(emailKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            // 取得 email
            String email = claims.getSubject();
            User user = userDao.getByEmail(email);
            // 檢查 email 是否存在
            if (user == null) {
                return new ExtractEmailTokenRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),//
                        ResMessage.EMAIL_NOT_EXISTED.getMessage());
            }
            return new ExtractEmailTokenRes(ResMessage.SUCCESS.getCode(),//
                    ResMessage.SUCCESS.getMessage(),email);
        }catch (Exception e) {
            return new ExtractEmailTokenRes(ResMessage.TOKEN_EXPIRED.getCode(),//
                    ResMessage.TOKEN_EXPIRED.getMessage());
        }
    }

    // 驗證 email 的 JWT 是否過期
    public boolean isTokenValid(String token) {
        try {
            Secret secret = getSecret();
            String emailSecret = secret.getEmailSecret();
            Key emailKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(emailSecret));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(emailKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            User user = userDao.getByEmail(email);
            if(user == null){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 產生重設密碼驗證碼
    public String generateResetPasswordToken(String email) {
        Secret secret = getSecret();
        String emailSecret = secret.getEmailSecret();
        Key emailKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(emailSecret));
        int expirationMillis = 1000 * 60 * 30; // 30 分鐘
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(emailKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 產生登入驗證碼用
    public String generateLoginToken(int userId, int version) {
        Secret secret = getSecret();
        String userSecret = secret.getUserSecret();
        Key userKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(userSecret));
        int expirationMillis = 1000 * 60 * 180; // 180 分鐘
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("version", version)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(userKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 驗證 JWT 是否過期，並拿出裡面的 userId 及 version
    public ExtractUserTokenRes extractUserToken(String token) {
        try {
            Secret secret = getSecret();
            String userSecret = secret.getUserSecret();
            Key userKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(userSecret));
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(userKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            // 取得 userId 及 version
            int userId = Integer.parseInt(claims.getSubject());
            int version = claims.get("version", Integer.class);
            User user = userDao.getByUserId(userId);
            // 檢查 userId 是否存在
            if(user == null){
                return new ExtractUserTokenRes(ResMessage.USER_ID_NOT_EXISTED.getCode(),//
                        ResMessage.USER_ID_NOT_EXISTED.getMessage());
            }
            return new ExtractUserTokenRes(ResMessage.SUCCESS.getCode(),//
                    ResMessage.SUCCESS.getMessage(), userId, version);
        }catch (Exception e) {
            return new ExtractUserTokenRes(ResMessage.TOKEN_EXPIRED.getCode(),//
                    ResMessage.TOKEN_EXPIRED.getMessage());
        }
    }

    // 驗證 userId 的 JWT 是否過期
    public boolean isUserIdTokenValid(String token) {
        try {
            Secret secret = getSecret();
            String userSecret = secret.getUserSecret();
            Key userKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(userSecret));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(userKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            int userId = Integer.parseInt(claims.getSubject());
            int version = claims.get("version", Integer.class);

            User user = userDao.getByUserId(userId);
            if(user == null){
                return false;
            }
            return user.getVersion()==version;
        } catch (Exception e) {
            return false;
        }
    }

    // 從資料庫取出 secret
    private Secret getSecret(){
        return secretDao.getSecret();
    }
}
