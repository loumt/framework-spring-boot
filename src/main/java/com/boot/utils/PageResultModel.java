package com.boot.utils;

import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@ToString
public class PageResultModel implements Serializable {

    private static final long serialVersionUID = 3462448388958695341L;
    private long count;
    private List list;
    private long total;

    public PageResultModel() {
    }

    public PageResultModel(List list) {
        this.list = list;
        this.count = list.size();
    }


    public PageResultModel(long count, List list) {
        this.count = count;
        this.list = list;
    }

    public PageResultModel total(long total) {
        this.total = total;
        return this;
    }

    public PageResultModel count(long count) {
        this.count = count;
        return this;
    }

    public PageResultModel list(List list) {
        this.list = list;
        return this;
    }

    public PageResultModel listAndCount(List list) {
        this.list = list;
        this.count = list.size();
        return this;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public static PageResultModel buildPageResultModel(List list) {
        return new PageResultModel(list);
    }

    public static PageResultModel buildPageResultModel(List list, long total) {
        return new PageResultModel(list).total(total);
    }
}
