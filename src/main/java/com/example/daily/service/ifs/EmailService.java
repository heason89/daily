package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;

public interface EmailService {

    public BasicRes sendVerificationEmail(String receiver, String token);

    public BasicRes sendResetPasswordEmail(String receiver, String token);
}
