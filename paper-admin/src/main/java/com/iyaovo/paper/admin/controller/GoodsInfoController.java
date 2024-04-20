package com.iyaovo.paper.admin.controller;

import com.iyaovo.paper.admin.domain.dto.GoodsInfoQueryParam;
import com.iyaovo.paper.admin.domain.entity.GoodsInfo;
import com.iyaovo.paper.admin.domain.vo.GoodsInfoVo;
import com.iyaovo.paper.admin.service.IGoodsInfoService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Tag(name =  "商品管理")
@RequestMapping("/product")
public class GoodsInfoController {
//    @Autowired
//    private PmsProductService productService;

    @Autowired
    private IGoodsInfoService iGoodsInfoService;

    @Operation(summary = "创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
//    public CommonResult create(@RequestBody PmsProductParam productParam) {
    public CommonResult create(@RequestBody GoodsInfo goodsInfo) {
        int count = iGoodsInfoService.create(goodsInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @Operation(summary = "更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Integer id, @RequestBody GoodsInfo goodsInfo) {
        int count = iGoodsInfoService.update(id, goodsInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GoodsInfoVo>> getList(GoodsInfoQueryParam goodsInfoQueryParam,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<GoodsInfoVo> goodsInfoVoList = iGoodsInfoService.list(goodsInfoQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(goodsInfoVoList));
    }

    @Operation(summary = "根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<GoodsInfoVo>> getList(String keyword) {
        List<GoodsInfoVo> goodsInfoVoList = iGoodsInfoService.list(keyword);
        return CommonResult.success(goodsInfoVoList);
    }



//    @Operation(summary = "批量修改删除状态")
//    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
//                                           @RequestParam("deleteStatus") Integer deleteStatus) {
//        int count = productService.updateDeleteStatus(ids, deleteStatus);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}
