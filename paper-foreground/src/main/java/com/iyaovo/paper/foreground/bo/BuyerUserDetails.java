/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: BuyerInfoDetails
 * Author: 22932
 * Date: 2024/4/22 17:36:30
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.bo;

import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: BuyerInfoDetails
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/22 17:36:30
 */
public class BuyerUserDetails implements UserDetails {

   //用户
   private final BuyerInfo buyerInfo;


   public BuyerUserDetails(BuyerInfo buyerInfo) {
      this.buyerInfo = buyerInfo;
   }


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
   }

   @Override
   public String getPassword() {
      return buyerInfo.getBuyerPassword();
   }

   @Override
   public String getUsername() {
      return buyerInfo.getBuyerName();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return false;
   }


}