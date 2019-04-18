package com.boot.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EntityScan
@Getter
@Setter
@ToString
@Document(collection = "boot_article")
public class Article {

    @Id
    private String id;
    private String title;
    @Indexed(unique = true)
    private String userId;
    private String content;
    private Date createTime;

}
