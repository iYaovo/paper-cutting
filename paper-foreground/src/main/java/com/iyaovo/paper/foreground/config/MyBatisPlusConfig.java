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

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
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
    //配置分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //数据库类型是MySql，因此参数填写DbType.MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}

