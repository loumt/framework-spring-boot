package service;

import com.boot.Application;
import com.boot.dao.UserDao;
import com.boot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void userSave() {
        User user = new User();
        user.setSex(1);
        user.setUsername("Lou Mingtao");
        userDao.saveUser(user);
    }

    @Test
    public void getUser(){
        List<User>  users = userDao.list(1,10);
        users.forEach(user -> System.out.println(user));

        System.out.println("========================");

        users.forEach(user -> {
            User u = userDao.findUser(user.getId());
            System.out.println(u);
        });
    }

}
