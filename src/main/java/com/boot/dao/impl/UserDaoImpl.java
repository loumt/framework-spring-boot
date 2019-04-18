package com.boot.dao.impl;

import com.boot.base.BaseDao;
import com.boot.dao.UserDao;
import com.boot.pojo.User;
import com.boot.utils.PageModel;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User findUser(String id) {
        return super.findUserById(id, User.class);
    }

    public void saveUser(User user) {
        super.save(user);
    }

    @Override
    public List<User> list(int page, int size) {
        return super.findByPage(page, size, User.class);
    }

    @Override
    public List<User> list(int page, int size, List<Criteria> criteria) {
        return super.findByPage(page, size, criteria, User.class);
    }

    @Override
    public long getTotal() {
        return super.getCount(User.class);
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public void delUser(String id) {
        super.destroyById(id, User.class);
    }
}
