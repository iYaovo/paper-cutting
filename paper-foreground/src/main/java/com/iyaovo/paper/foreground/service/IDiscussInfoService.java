package com.iyaovo.paper.foreground.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.foreground.domain.dto.DiscussDto;
import com.iyaovo.paper.foreground.domain.entity.DiscussInfo;
import com.iyaovo.paper.foreground.domain.vo.DiscussCommentVo;
import com.iyaovo.paper.foreground.domain.vo.DiscussInfoVo;
import com.iyaovo.paper.foreground.domain.vo.GoodsInfoVo;

import java.util.List;

public interface IDiscussInfoService extends IService<DiscussInfo>{

    /**
     * 展示广场讨论区
     */
    CommonPage<DiscussInfoVo> showDiscuss(Integer pageNum,
                                          Integer pageSize);

    /**
     * 展开评论
     */
    List<DiscussCommentVo> showDiscussComments(Integer discussId);

    /**
     * 点赞
     */
    void like(Integer discussId);

    /**
     * 发表讨论
     */
    void publishDiscuss(DiscussDto discussDto);
}
