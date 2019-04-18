package com.boot.services.impl;

import com.boot.base.BaseService;
import com.boot.dao.UserDao;
import com.boot.enums.ResultCode;
import com.boot.pojo.User;
import com.boot.services.UserService;
import com.boot.utils.PageModel;
import com.boot.utils.PageResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResultCode register(User user) {
        userDao.saveUser(user);
        return ResultCode.SUCCESS;
    }

    @Override
    public PageResultModel getList(PageModel pageModel) {
        List<User> users = null;
        long count = userDao.getTotal();
        if (pageModel.getCriteria().size() == 0) {
            users = userDao.list(pageModel.getPage(), pageModel.getSize());
        } else {
            users = userDao.list(pageModel.getPage(), pageModel.getSize(), pageModel.getCriteria());
        }
        return PageResultModel.buildPageResultModel(users, count);
    }

    @Override
    public ResultCode deleteUser(String id) {
        userDao.delUser(id);
        return ResultCode.SUCCESS;
    }

    @Override
    public User findUser(String id) {
        return userDao.findUser(id);
    }

}
