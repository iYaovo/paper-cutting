/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ForegroundSecurityConfig
 * Author: 22932
 * Date: 2024/4/23 15:02:46
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.config;

import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.security.component.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ForegroundSecurityConfig
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/23 15:02:46
 */
@Configuration
public class ForegroundSecurityConfig {

   @Autowired
   private IBuyerInfoService iBuyerInfoService;


   @Bean
   public UserDetailsService userDetailsService() {
      //获取登录用户信息
      return username -> iBuyerInfoService.loadUserByUsername(username);
   }


}