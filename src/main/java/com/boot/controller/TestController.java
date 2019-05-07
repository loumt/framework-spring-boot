package com.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = {"Test-Api"})
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(httpMethod = "GET", value = "测试", notes = "测试接口")
    public String test() {
        return "Hello Spring Boot.";
    }


    @RequestMapping("/list")
    @ApiOperation(httpMethod = "GET", value = "页面测试接口", notes = "使用Freemarket接口", response = String.class)
    public String index(Map<String, Object> result) {
        result.put("name", "jhp");
        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "wangli");
        friend.put("age", 28);
        friend.put("love", "编程");
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "guoyanbin");
        friend.put("age", 29);
        friend.put("love", "打游戏");
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "yaodong");
        friend.put("age", 26);
        friend.put("love", "深蹲");
        friends.add(friend);
        result.put("friends", friends);
        return "list";
    }

}
