package com.fengwenyi.springcloud_module_order.api;

import com.fengwenyi.springcloud_service_api.ServiceUserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/22 13:33
 */
@FeignClient("SpringCloud-Module-User")
public interface ApiUserClient extends ServiceUserApi {
}
