package com.example.daily.service.impl;


import com.example.daily.constants.ResMessage;
import com.example.daily.service.ifs.EmailService;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.BasicRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public BasicRes sendVerificationEmail(String toUser, String token) {
        String link = "http://172.16.0.86:8080/daily/verify?token=" + token;

        String subject = "請驗證您的帳號 - HealthyDiaryApp";
        String content = "Hi 使用者您好，\n\n" +
                "感謝您註冊 HealthyDiaryApp，請點擊以下連結完成您的帳號驗證：\n" +
                link + "\n\n" +
                "祝您使用愉快，\n" +
                "HealthyDiaryApp 團隊";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toUser);                          // 設定收件人
        message.setSubject(subject);           // 設定信件標題
        message.setText(content); // 信件正文（文字）
        mailSender.send(message);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes sendResetPasswordEmail(String toEmail, String token) {
        String link = "http://172.16.0.86:8080/daily/reset-password?token=" + token;

        String subject = "重設您的密碼 - HealthyDiaryApp";
        String content = "Hi 使用者您好，\n\n" +
                "我們收到您重設密碼的請求，請點擊以下連結重新設定您的密碼：\n" +
                link + "\n\n" +
                "此連結將於 30 分鐘後失效，若您未曾提出此請求，請忽略此信。\n\n" +
                "祝您使用愉快，\n" +
                "HealthyDiaryApp 團隊";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        return new BasicRes(ResMessage.SUCCESS.getCode(),
                ResMessage.SUCCESS.getMessage());
    }
}
