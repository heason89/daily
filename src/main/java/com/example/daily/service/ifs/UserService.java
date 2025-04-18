package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.LoginReq;
import com.example.daily.vo.RegisterReq;
import com.example.daily.vo.UpdateUserReq;

public interface UserService {

    public BasicRes login(LoginReq req);

    public BasicRes register(RegisterReq req);

    public BasicRes updateUserInfo(UpdateUserReq req);
}
