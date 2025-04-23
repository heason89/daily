package com.example.daily.service.ifs;

import com.example.daily.vo.*;


public interface UserService {

    public BasicRes login(LoginReq req);

    public BasicRes register(RegisterReq req);

    public BasicRes updateUserInfo(UpdateUserReq req);

    public BasicRes updatePhoto(PhotoReq req);

    public BasicRes sendResetPasswordEmail(String email);

    public GetUserInfoRes getUserInfo(GetUserInfoReq req);

    public BasicRes verifyToken(String token);

    public BasicRes verifyTokenUpdatePassword(String token, String newPassword);
}
