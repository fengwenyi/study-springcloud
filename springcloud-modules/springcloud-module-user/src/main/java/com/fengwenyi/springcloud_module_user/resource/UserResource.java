package com.fengwenyi.springcloud_module_user.resource;

import com.fengwenyi.springcloud_common_model.UserModel;
import com.fengwenyi.springcloud_service_api.UserService;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 11:35
 */
@RestController
public class UserResource implements UserService {
    @Override
    public List<UserModel> getUsers() {
        return Collections.singletonList(
                new UserModel()
                        .setNickname("Zhangsan")
                        .setAge(20));
    }
}
