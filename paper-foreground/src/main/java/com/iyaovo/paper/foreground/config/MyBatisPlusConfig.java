/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: MyBatisPlusConfig
 * Author: 22932
 * Date: 2024/4/11 09:51:40
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MyBatisPlusConfig
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/11 09:51:40
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.iyaovo.paper.foreground.mapper"})
public class MyBatisPlusConfig {
}

