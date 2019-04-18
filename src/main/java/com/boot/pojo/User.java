package com.boot.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EntityScan
@ToString
@Getter
@Setter
@Document(collection = "boot_user")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String realName;
    private Integer sex;
    private String phone;
    private String email;
    private Date createTime;
    private boolean enable;
}
