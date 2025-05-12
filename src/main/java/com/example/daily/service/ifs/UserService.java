package com.example.daily.service.ifs;

import com.example.daily.vo.*;


public interface UserService {

    public LoginRes login(LoginReq req);

    public BasicRes logout(LogoutReq req);

    public BasicRes register(RegisterReq req);

    public BasicRes updateUserInfo(UpdateUserReq req);

    public BasicRes sendResetPasswordEmail(SendEmailReq req);

    public GetUserInfoRes getUserInfo(GetUserDataReq req);

    public BasicRes verifyToken(VerifyTokenReq req);

    public BasicRes verifyTokenUpdatePassword(ResetPasswordReq req);
}
