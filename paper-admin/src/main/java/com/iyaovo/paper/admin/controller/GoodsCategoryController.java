package com.iyaovo.paper.admin.controller;

import com.iyaovo.paper.admin.domain.dto.GoodsCategoryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsCategory;
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

    @Operation(description = "添加商品分类")
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
    public CommonResult<CommonPage<GoodsCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<GoodsCategory> goodsCategory = iGoodsCategoryService.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(goodsCategory));
    }

//    @Operation(summary = "根据id获取商品分类")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<PmsProductCategory> getItem(@PathVariable Long id) {
//        PmsProductCategory productCategory = iGoodsCategoryService.getItem(id);
//        return CommonResult.success(productCategory);
//    }

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

//    @Operation(summary = "查询所有一级分类及子分类")
//    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
//        List<PmsProductCategoryWithChildrenItem> list = iGoodsCategoryService.listWithChildren();
//        return CommonResult.success(list);
//    }
}
