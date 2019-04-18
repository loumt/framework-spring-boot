package com.boot.controller;

import com.boot.base.BaseController;
import com.boot.enums.ResultCode;
import com.boot.pojo.User;
import com.boot.services.UserService;
import com.boot.utils.PageModel;
import com.boot.utils.PageResultModel;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@Api(value = "API[User]",tags = {"User-API"})
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册", notes = "用户通过此接口注册", responseContainer = "Map", httpMethod = "POST")
    @ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
    @PostMapping(value = "/register")
    public Map<String, Object> register(@RequestBody User user) {
        user.setCreateTime(new Date());
        ResultCode resultCode = userService.register(user);
        return super.isBackMap(resultCode);
    }


    @ApiOperation(value = "用户列表", notes = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页实体-页码", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "分页实体-页显示数", required = true, paramType = "query", dataType = "int")
    })
    @GetMapping
    public Map<String, Object> allUsers(int page, int size) {
        PageModel pageModel = new PageModel(page, size);
        PageResultModel resultModel = userService.getList(pageModel);
        return super.isCommonSuccess(resultModel);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个用户", notes = "获取某个用户")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "String")
    public Map<String, Object> findUser(@PathVariable String id) {
        User user = userService.findUser(id);
        return super.isCommonSuccess(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "删除某个用户")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "String")
    public Map<String, Object> delUser(@PathVariable String id) {
        userService.deleteUser(id);
        return super.isCommonSuccess();
    }

}
