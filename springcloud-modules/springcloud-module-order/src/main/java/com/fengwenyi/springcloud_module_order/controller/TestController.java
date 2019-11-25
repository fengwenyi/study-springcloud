package com.fengwenyi.springcloud_module_order.controller;

import com.fengwenyi.springcloud_common_model.UserModel;
import com.fengwenyi.springcloud_module_order.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 11:39
 */
@RestController
@RequestMapping("/order/test")
public class TestController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userClient.getUsers();
    }
}
