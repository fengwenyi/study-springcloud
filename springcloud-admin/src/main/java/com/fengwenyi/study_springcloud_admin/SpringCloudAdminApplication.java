package com.fengwenyi.study_springcloud_admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/2 09:11
 */
@SpringCloudApplication
@EnableAdminServer
public class SpringCloudAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAdminApplication.class, args);
    }

}
