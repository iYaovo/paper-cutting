/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: DiscussInfoServiceImpl
 * Author: 22932
 * Date: 2024/5/7 14:33:45
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.DiscussDto;
import com.iyaovo.paper.foreground.domain.entity.BuyerInfo;
import com.iyaovo.paper.foreground.domain.entity.DiscussInfo;
import com.iyaovo.paper.foreground.domain.vo.DiscussCommentVo;
import com.iyaovo.paper.foreground.domain.vo.DiscussInfoVo;
import com.iyaovo.paper.foreground.mapper.BuyerInfoMapper;
import com.iyaovo.paper.foreground.mapper.DiscussInfoMapper;
import com.iyaovo.paper.foreground.service.IBuyerInfoService;
import com.iyaovo.paper.foreground.service.IDiscussInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DiscussInfoServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/7 14:33:45
 */
@Service
@RequiredArgsConstructor
public class DiscussInfoServiceImpl extends ServiceImpl<DiscussInfoMapper, DiscussInfo> implements IDiscussInfoService {

   private final DiscussInfoMapper discussInfoMapper;

   private final BuyerInfoMapper buyerInfoMapper;

   private final IBuyerInfoService iBuyerInfoService;

   @Override
   public CommonPage<DiscussInfoVo> showDiscuss(Integer pageNum, Integer pageSize) {
      QueryWrapper<DiscussInfo> discussInfoQueryWrapper = new QueryWrapper<>();
      discussInfoQueryWrapper.eq("parent_id",0);
      Page<DiscussInfo> discussInfoPage = discussInfoMapper.selectPage(new Page<>(pageNum,pageSize), discussInfoQueryWrapper);
      List<DiscussInfoVo> discussInfoVos = new ArrayList<>();
      discussInfoPage.getRecords().forEach(discussInfo -> {
            BuyerInfo buyerInfo = buyerInfoMapper.selectById(discussInfo.getBuyerId());
            DiscussInfoVo discussInfoVo = new DiscussInfoVo(discussInfo.getDiscussId(),discussInfo.getDiscussContent(),
                    discussInfo.getFavoriteNumber(),discussInfo.getCommentNumber(),buyerInfo.getPicUrl(),buyerInfo.getBuyerName());
            discussInfoVos.add(discussInfoVo);
      });
      Page<DiscussInfoVo> discussInfoVoPage = new Page<>(pageNum,pageSize,discussInfoPage.getTotal());
      discussInfoVoPage.setPages(discussInfoPage.getPages());
      discussInfoVoPage.setRecords(discussInfoVos);
      return CommonPage.restPage(discussInfoVoPage);
   }

   @Override
   public List<DiscussCommentVo> showDiscussComments(Integer discussId) {
      QueryWrapper<DiscussInfo> discussInfoQueryWrapper = new QueryWrapper<>();
      discussInfoQueryWrapper.eq("parent_id",discussId);
      List<DiscussInfo> discussInfoList = discussInfoMapper.selectList(discussInfoQueryWrapper);
      List<DiscussCommentVo> discussCommentVos = new ArrayList<>();
      discussInfoList.forEach(discussInfo -> {
         BuyerInfo buyerInfo = buyerInfoMapper.selectById(discussInfo.getBuyerId());
         DiscussCommentVo discussCommentVo = new DiscussCommentVo(discussInfo.getDiscussId(),discussInfo.getDiscussContent(),buyerInfo.getPicUrl(),buyerInfo.getBuyerName());
         discussCommentVos.add(discussCommentVo);
      });
      return discussCommentVos;
   }

   @Override
   public void like(Integer discussId) {
      UpdateWrapper<DiscussInfo> discussInfoUpdateWrapper = new UpdateWrapper<>();
      discussInfoUpdateWrapper.eq("discuss_id", discussId);
      discussInfoUpdateWrapper.setSql("favorite_number = favorite_number + 1");
      discussInfoMapper.update(null, discussInfoUpdateWrapper);
   }

   @Override
   public void publishDiscuss(DiscussDto discussDto) {
      discussInfoMapper.insert(new DiscussInfo(null,iBuyerInfoService.getBuyerInfo().getBuyerId(),discussDto.getParentId(),discussDto.getDiscussContent()));
      if(discussDto.getParentId()!=0){
         UpdateWrapper<DiscussInfo> discussInfoUpdateWrapper = new UpdateWrapper<>();
         discussInfoUpdateWrapper.eq("discuss_id", discussDto.getParentId());
         discussInfoUpdateWrapper.setSql("comment_number = comment_number + 1");
         discussInfoMapper.update(null, discussInfoUpdateWrapper);
      }
   }

}

