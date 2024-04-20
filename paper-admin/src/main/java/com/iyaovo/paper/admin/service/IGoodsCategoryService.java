package com.iyaovo.paper.admin.service;

import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsCategory;

import java.util.List;

public interface IGoodsCategoryService{



    /**
     * 添加类别
     */
    int create(GoodsCategoryParam goodsCategoryParam);



    /**
     * 删除类别
     */
    int delete(Integer goodsCategoryId);



    /**
     * 修改类别
     */
    int update(Integer id,GoodsCategoryParam goodsCategoryParam);

    /**
     * 分页获取商品分类
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<GoodsCategory> getList(Long parentId, Integer pageSize, Integer pageNum);
}
