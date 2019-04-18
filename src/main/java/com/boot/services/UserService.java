package com.boot.services;

import com.boot.enums.ResultCode;
import com.boot.pojo.User;
import com.boot.utils.PageModel;
import com.boot.utils.PageResultModel;
import com.boot.utils.ResultModel;

public interface UserService{

    ResultCode register(User user);

    PageResultModel getList(PageModel pageModel);

    ResultCode deleteUser(String id);

    User findUser(String id);
}
