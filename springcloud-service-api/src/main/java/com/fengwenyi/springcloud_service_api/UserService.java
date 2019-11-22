package com.fengwenyi.springcloud_service_api;

import com.fengwenyi.springcloud_common_model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 11:32
 */
public interface UserService {

    @GetMapping("/users")
    List<UserModel> getUsers();

}
