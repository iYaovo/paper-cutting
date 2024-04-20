package com.iyaovo.paper.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {
    @Select("SELECT * FROM goods_info ORDER BY RAND() LIMIT #{limit}")
    List<GoodsInfo> selectRandomProducts(@Param("limit") int limit);
}
