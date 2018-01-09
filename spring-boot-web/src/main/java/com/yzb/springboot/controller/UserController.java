package com.yzb.springboot.controller;

import com.yzb.springboot.model.Users;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Create by yuzhangbin on 2018/1/8
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long,Users> users = Collections.synchronizedMap(new HashMap<Long,Users>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Users> getUserList() {
        List<Users> r = new ArrayList<Users>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute Users user) {
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Users getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id,@ModelAttribute Users user) {
        Users u = users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
