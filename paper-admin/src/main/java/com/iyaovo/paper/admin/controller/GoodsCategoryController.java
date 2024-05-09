package com.iyaovo.paper.admin.controller;

import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.dto.GoodsCategoryWithChildrenItem;
import com.iyaovo.paper.admin.domain.vo.GoodsCategoryVo;
import com.iyaovo.paper.admin.service.IGoodsCategoryService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Tag(name = "商品分类管理")
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    @Autowired
    private IGoodsCategoryService iGoodsCategoryService;

    @Operation(summary = "获取单个分类")
    @RequestMapping(value = "/{goodsCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOne(@PathVariable("goodsCategoryId") Integer goodsCategoryId) {
        return CommonResult.success(iGoodsCategoryService.getOneGoodsCategory(goodsCategoryId));
    }


    @Operation(summary = "添加商品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody GoodsCategoryParam goodsCategoryParam) {
        int count = iGoodsCategoryService.create(goodsCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Integer id,
                         @Validated
                         @RequestBody GoodsCategoryParam goodsCategoryParam) {
        int count = iGoodsCategoryService.update(id, goodsCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GoodsCategoryVo>> getList(@PathVariable Long parentId,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(CommonPage.restPage(iGoodsCategoryService.getList(parentId, pageSize, pageNum)));
    }



    @Operation(summary = "删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Integer id) {
        int count = iGoodsCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<GoodsCategoryWithChildrenItem>> listWithChildren() {
        List<GoodsCategoryWithChildrenItem> list = iGoodsCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
