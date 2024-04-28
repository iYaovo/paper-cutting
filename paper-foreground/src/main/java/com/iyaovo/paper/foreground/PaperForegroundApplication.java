/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: PaperForegroundApplication
 * Author: 22932
 * Date: 2024/4/11 08:15:22
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: PaperForegroundApplication
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/11 08:15:22
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.iyaovo.paper.common","com.iyaovo.paper.foreground","com.iyaovo.paper.security"})
public class PaperForegroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaperForegroundApplication.class, args);
    }
}

