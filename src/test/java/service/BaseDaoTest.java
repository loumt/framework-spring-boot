package service;

import com.boot.Application;
import com.boot.base.BaseDao;
import com.boot.config.GlobalConfig;
import com.boot.config.RedisConfigure;
import com.boot.pojo.User;
import com.boot.utils.PageModel;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseDaoTest {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Autowired
    private RedisConfigure redisConfigure;

    @Autowired
    private GlobalConfig globalConfig;

    @Test
    public void saveTest(){
        Map<String,String> map = new HashMap<>();
        map.put("username","loumt");

        BasicQuery basicQuery = new BasicQuery(new Document("username","loumt"));

        User user = mongoTemplate.findOne(basicQuery, User.class);
        System.out.println(user);

        System.out.println(redisConfigure.getHost());

        System.out.println(globalConfig.getAppDescription());
    }


    @Test
    public void getUserList(){
//        List<User> users = baseDao.findByPage(1,10, User.class);
//        long count = baseDao.getCount(User.class);
//        for(User user: users){
//            System.out.println(user);
//        }
//        System.out.println(count);
    }


    @Test
    public void getUserCount(){
//        Criteria criteria = Criteria.where("username").is("loumt");
//        List<Criteria> list = new ArrayList<>();
//        list.add(criteria);
//
//        long count = baseDao.getCount(list, User.class);
//        System.out.println(count);
    }

}
