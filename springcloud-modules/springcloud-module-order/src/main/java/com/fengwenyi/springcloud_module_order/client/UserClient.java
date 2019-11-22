package com.fengwenyi.springcloud_module_order.client;

import com.fengwenyi.springcloud_service_api.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 13:33
 */
@FeignClient("SpringCloud-Module-User")
public interface UserClient extends UserService {
}
