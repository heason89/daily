package com.example.daily.service.impl;


import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SenderDao;
import com.example.daily.entity.Sender;
import com.example.daily.service.ifs.EmailService;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.BasicRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SenderDao senderDao;

    @Override
    public BasicRes sendVerificationEmail(String toEmail, String token) {
        Sender sender = senderDao.getSender();
        JavaMailSenderImpl mailSender =new JavaMailSenderImpl();

        // 設定寄件者資料
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(sender.getEmail());
        mailSender.setPassword(sender.getPassword());

        //取得 JavaMailSenderImpl 裡面負責 SMTP 傳輸協議的屬性設定表
        Properties props = mailSender.getJavaMailProperties();
        // 發信時要啟用「SMTP 驗證」機制，這對於 Gmail 來說是 必要的，否則你會被拒絕連線。
        props.put("mail.smtp.auth", "true");
        // 啟用 STARTTLS 加密機制，由於 Gmail 必須啟用 STARTTLS 才能寄信
        props.put("mail.smtp.starttls.enable", "true");

        SimpleMailMessage message = getVerificationMessage(toEmail, token);
        mailSender.send(message);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    private static SimpleMailMessage getVerificationMessage(String toEmail, String token) {
        String link = "http://localhost:4200/confirm?token=" + token;

        String subject = "請驗證您的帳號 - HealthyDiaryApp";
        String content = "Hi 使用者您好，\n\n" +
                "感謝您註冊 HealthyDiaryApp，請點擊以下連結完成您的帳號驗證：\n" +
                link + "\n\n" +
                "此連結將於 30 分鐘後失效，若您未曾提出此請求，請忽略此信。\n\n" +
                "祝您使用愉快，\n" +
                "HealthyDiaryApp 團隊";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);                          // 設定收件人
        message.setSubject(subject);           // 設定信件標題
        message.setText(content); // 信件正文（文字）
        return message;
    }

    @Override
    public BasicRes sendResetPasswordEmail(String toEmail, String token) {
        Sender sender = senderDao.getSender();
        JavaMailSenderImpl mailSender =new JavaMailSenderImpl();

        // 設定寄件者資料
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(sender.getEmail());
        mailSender.setPassword(sender.getPassword());

        //取得 JavaMailSenderImpl 裡面負責 SMTP 傳輸協議的屬性設定表
        Properties props = mailSender.getJavaMailProperties();
        // 發信時要啟用「SMTP 驗證」機制，這對於 Gmail 來說是 必要的，否則你會被拒絕連線。
        props.put("mail.smtp.auth", "true");
        // 啟用 STARTTLS 加密機制，由於 Gmail 必須啟用 STARTTLS 才能寄信
        props.put("mail.smtp.starttls.enable", "true");

        SimpleMailMessage message = getResetPasswordMessage(toEmail, token);
        mailSender.send(message);

        return new BasicRes(ResMessage.SUCCESS.getCode(),
                ResMessage.SUCCESS.getMessage());
    }

    private static SimpleMailMessage getResetPasswordMessage(String toEmail, String token) {
        String link = "http://localhost:4200/editpassword?token=" + token;

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
        return message;
    }
}
