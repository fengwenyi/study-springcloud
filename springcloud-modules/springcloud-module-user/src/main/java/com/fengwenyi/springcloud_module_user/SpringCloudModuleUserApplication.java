package com.fengwenyi.springcloud_module_user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng<xfsy_2015@163.com>
 * @since 2019/11/20 09:52
 */
@RestController
@SpringCloudApplication
public class SpringCloudModuleUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudModuleUserApplication.class, args);
    }

    @Value("${user}")
    private String user;

    @RequestMapping
    public String home() {
        return user;
    }
}
