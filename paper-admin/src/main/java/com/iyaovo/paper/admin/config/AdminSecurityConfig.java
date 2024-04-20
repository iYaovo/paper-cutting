/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: SecurityConfig
 * Author: 22932
 * Date: 2024/4/16 19:02:01
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.admin.config;

import com.iyaovo.paper.admin.domain.entity.UmsResource;
import com.iyaovo.paper.admin.service.UmsAdminService;
import com.iyaovo.paper.admin.service.UmsResourceService;
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
 * @ClassName: SecurityConfig
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/16 19:02:01
 */
@Configuration
public class AdminSecurityConfig {

   @Autowired
   private UmsAdminService adminService;
   @Autowired
   private UmsResourceService resourceService;

   @Bean
   public UserDetailsService userDetailsService() {
      //获取登录用户信息
      return username -> adminService.loadUserByUsername(username);
   }

   @Bean
   public DynamicSecurityService dynamicSecurityService() {
      return new DynamicSecurityService() {
         @Override
         public Map<String, ConfigAttribute> loadDataSource() {
            Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
            List<UmsResource> resourceList = resourceService.listAll();
            for (UmsResource resource : resourceList) {
               map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
         }
      };
   }
}


