package com.fengwenyi.springcloud_module_order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/11/21 15:59
 */
@EnableFeignClients
@SpringCloudApplication
public class SpringCloudModuleOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudModuleOrderApplication.class, args);
    }

}
