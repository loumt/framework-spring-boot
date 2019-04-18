package com.boot.dao;

import com.boot.base.BaseDao;
import com.boot.pojo.User;
import com.boot.utils.PageModel;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public interface UserDao{

    User findUser(String id);

    void saveUser(User user);

    List<User> list(int page,int size);

    List<User> list(int page, int size, List<Criteria> criteria);

    long getTotal();

    long getCount();

    void delUser(String id);
}
