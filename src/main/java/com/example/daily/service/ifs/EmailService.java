package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;

public interface EmailService {
    public BasicRes sendVerificationEmail(String to, String token);

    public BasicRes sendResetPasswordEmail(String toEmail, String resetLink);
}
