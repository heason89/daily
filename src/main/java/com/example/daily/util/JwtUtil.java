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
import io.jsonwebtoken.security.SignatureException;

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

    // 設定兩種的 token 有效期限
    int emailExpired = 1000 * 60 * 30; // 30 分鐘
    int userExpired = 1000 * 60 * 120; // 120 分鐘
    // 產生註冊驗證碼
    public String generateRegisterToken(String email) {
        Key emailKey = getEmailKey();
        // Jwts.builder() 代表建立一個新的 JWT
        // setSubject() 代表 token 的主體，主要設定信箱用(收件者)
        // setIssuedAt() 代表 token 被建立的時間
        // setExpiration() 代表 token 的過期時間
        // signWith(emailKey,SignatureAlgorithm.HS256) 代表用 emailKey 與 HS256 演算法簽署 token ，確保來源可信且未被竄改
        // compact() 代表把整個 Token 編碼成一個字串（JWT 字串）
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + emailExpired))
                .signWith(emailKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 產生重設密碼驗證碼
    public String generateResetPasswordToken(String email) {
        Key emailKey = getEmailKey();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + emailExpired))
                .signWith(emailKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 驗證 JWT 是否過期，並拿出裡面的 Email
    public ExtractEmailTokenRes extractEmailToken(String token) {
        try {
            Key emailKey = getEmailKey();
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
        }catch (ExpiredJwtException e) {
            // Token 已過期
            return new ExtractEmailTokenRes(ResMessage.TOKEN_EXPIRED.getCode(),//
                    ResMessage.TOKEN_EXPIRED.getMessage());
        }catch ( SignatureException | MalformedJwtException e) {
            // Token 簽名驗證失敗，可能被竄改，或是 Token 格式錯誤，可能是無效字串
            return new ExtractEmailTokenRes(ResMessage.INVALID_TOKEN.getCode(),//
                    ResMessage.INVALID_TOKEN.getMessage());
        }catch (Exception e) {
            // 其他錯誤，如轉型錯、NullPointer 等
            return new ExtractEmailTokenRes(ResMessage.TOKEN_ERROR.getCode(),//
                    ResMessage.TOKEN_ERROR.getMessage());
        }
    }

    // 產生登入驗證碼用
    public String generateLoginToken(int userId, int version) {
        Key userKey = getUserKey();
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("version", version)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + userExpired))
                .signWith(userKey,SignatureAlgorithm.HS256)
                .compact();
    }

    // 驗證 JWT 是否過期，並拿出裡面的 userId 及 version
    public ExtractUserTokenRes extractUserToken(String token) {
        try {
            Key userKey = getUserKey();
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
        }catch (ExpiredJwtException e) {
            // Token 已過期
            return new ExtractUserTokenRes(ResMessage.TOKEN_EXPIRED.getCode(),//
                    ResMessage.TOKEN_EXPIRED.getMessage());
        }catch ( SignatureException | MalformedJwtException e) {
            // Token 簽名驗證失敗，可能被竄改，或是 Token 格式錯誤，可能是無效字串
            return new ExtractUserTokenRes(ResMessage.INVALID_TOKEN.getCode(),//
                    ResMessage.INVALID_TOKEN.getMessage());
        }catch (Exception e) {
            // 其他錯誤，如轉型錯、NullPointer 等
            return new ExtractUserTokenRes(ResMessage.TOKEN_ERROR.getCode(),//
                    ResMessage.TOKEN_ERROR.getMessage());
        }
    }

    // 預設值，目的是讓資料庫只取一次
    private Secret secret = null;
    private String userSecret = null;
    private String emailSecret = null;
    // 從資料庫取出 secret
    private Secret getSecret(){
        if(secret == null){
            secret =  secretDao.getSecret();
        }
        return secret;
    }
    // 取得 emailSecret
    private Key getEmailKey(){
        Secret secret = getSecret();
        // 取出 secret 裡的 email 用的 emailSecret (Base64 編碼)
        // 解碼 emailSecret 並轉換為 Key，用於簽署 JWT
        // 目的是確保該 token 是我方所簽發的，且才能正常解析 token
        if(emailSecret == null) {
            emailSecret = secret.getEmailSecret();
        }
        // 將 Base64 編碼的 emailSecret 轉換為 Key，用來簽署 JWT
        return  Keys.hmacShaKeyFor(Base64.getDecoder().decode(emailSecret));
    }
    // 取得 userSecret
    private Key getUserKey(){
        Secret secret = getSecret();
        // 取出 secret 裡的 user 用的 userSecret (Base64 編碼)
        // 解碼 userSecret 並轉換為 Key，用於簽署 JWT
        // 目的是確保該 token 是我方所簽發的，且才能正常解析 token
        if(userSecret == null) {
            userSecret = secret.getUserSecret();
        }
        // 將 Base64 編碼的 userSecret 轉換為 Key，用來簽署 JWT
        return  Keys.hmacShaKeyFor(Base64.getDecoder().decode(userSecret));
    }
}
