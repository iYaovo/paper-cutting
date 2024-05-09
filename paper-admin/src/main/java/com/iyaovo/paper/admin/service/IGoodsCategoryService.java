package com.iyaovo.paper.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.admin.domain.vo.GoodsCategoryVo;

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
    Page<GoodsCategoryVo> getList(Long parentId, Integer pageSize, Integer pageNum);

    List<GoodsCategoryWithChildrenItem> listWithChildren();

    GoodsCategoryVo getOneGoodsCategory(Integer goodsCategoryId);

}
