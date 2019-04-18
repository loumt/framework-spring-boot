package com.boot.base;

import com.boot.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BaseDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Query buildQueryWithPageModel(Query query, PageModel pageModel) {
        Pageable pageable = PageRequest.of(pageModel.getPage() - 1, pageModel.getSize());
        return query.with(pageable);
    }

    private Query buildQueryWithCriteria(Query query, List<Criteria> criteria) {
        for (Criteria ctl : criteria) {
            query.addCriteria(ctl);
        }
        return query;
    }

    protected void save(Object obj) {
        this.mongoTemplate.save(obj);
    }

    protected <T> List<T> findByPage(int page, int size, Class<T> entityClass) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.mongoTemplate.find(query.with(pageable), entityClass);
    }

    protected <T> List<T> findByPage(int page, int size, List<Criteria> criteria, Class<T> entityClass) {
        Query query = new Query();
        for (Criteria ctl : criteria) {
            query.addCriteria(ctl);
        }
        Pageable pageable = PageRequest.of(page - 1, size);
        return this.mongoTemplate.find(query.with(pageable), entityClass);
    }

    protected <T> long getCount(Class<T> entityClass) {
        return this.mongoTemplate.count(new Query(), entityClass);
    }


    protected <T> long getCount(List<Criteria> criteria, Class<T> entityClass) {
        Query query = new Query();
        Query withCriteria = this.buildQueryWithCriteria(query, criteria);
        return this.mongoTemplate.count(withCriteria, entityClass);
    }

    protected <T> void destroyById(String id, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(new Criteria("id").is(id));
        this.mongoTemplate.remove(query, entityClass);
    }


    protected <T> T updateById(String id, Map<String, Object> updateOptions, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(new Criteria("id").is(id));
        Update update = new Update();
        updateOptions.forEach((key, value) -> update.set(key, value));
        return this.mongoTemplate.findAndModify(query, update, entityClass);
    }

    protected <T> T findUserById(String id, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(new Criteria("id").is(id));
        return this.mongoTemplate.findOne(query, entityClass);
    }


}
