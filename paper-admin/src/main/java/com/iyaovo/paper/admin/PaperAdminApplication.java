package com.iyaovo.paper.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.iyaovo.paper.common","com.iyaovo.paper.admin","com.iyaovo.paper.security"})
public class PaperAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaperAdminApplication.class, args);
    }
}
