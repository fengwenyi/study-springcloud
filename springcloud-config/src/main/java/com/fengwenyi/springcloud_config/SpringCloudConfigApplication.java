package com.fengwenyi.springcloud_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Erwin Feng<xfsy_2015@163.com>
 * @since 2019/11/19 09:23
 */
@SpringCloudApplication
@EnableEurekaClient
@EnableConfigServer
@EnableAutoConfiguration
public class SpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
    }

}
