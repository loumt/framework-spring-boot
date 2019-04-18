package com.boot.utils;

import lombok.ToString;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

@ToString
public class PageModel {

    private int page;
    private int size;
    private List<Criteria> criteria = new ArrayList<Criteria>();

    public PageModel() {
    }

    public PageModel(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        this.criteria = criteria;
    }

    public void addCriteria(Criteria cta){
        this.criteria.add(cta);
    }
}
