package com.iyaovo.paper.admin.controller;

import com.iyaovo.paper.admin.domain.dto.ShopInfoParam;
import com.iyaovo.paper.admin.domain.vo.ShopInfoVo;
import com.iyaovo.paper.admin.service.IShopInfoService;
import com.iyaovo.paper.common.api.CommonPage;
import com.iyaovo.paper.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品店铺管理Controller
 * Created by macro on 2018/4/26.
 */

@Tag(name = "商品店铺管理")
@RestController
@RequestMapping("/shop")
@Slf4j
@RequiredArgsConstructor
public class ShopController {

    private final IShopInfoService iShopInfoService;

    @Operation(summary = "获取单个店铺")
    @RequestMapping(value = "/{shopId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getOne(@PathVariable("shopId") Integer shopId) {
        return CommonResult.success(iShopInfoService.getOneShop(shopId));
    }

    @Operation(summary = "获取全部店铺列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<ShopInfoVo>> getList() {
        return CommonResult.success(iShopInfoService.listAllShop());
    }

    @Operation(summary = "添加店铺")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@Validated @RequestBody ShopInfoParam shopInfoParam) {
        CommonResult commonResult;
        int count = iShopInfoService.createShop(shopInfoParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @Operation(summary = "更新店铺")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable("id") Integer id,
                               @Validated @RequestBody ShopInfoParam shopInfoParam) {
        CommonResult commonResult;
        int count = iShopInfoService.updateShop(id,shopInfoParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @Operation(summary = "删除店铺")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult delete(@PathVariable("id") Integer id) {
        int count = iShopInfoService.deleteShop(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "根据店铺名称分页获取店铺列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<ShopInfoVo>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonResult.success(CommonPage.restPage(iShopInfoService.listShop(keyword,pageNum, pageSize)));
    }


    @Operation(summary = "批量删除店铺")
    @PostMapping(value = "/delete/batch")
    public CommonResult deleteBatch(@RequestParam("ids") List<Integer> ids) {
        int count = iShopInfoService.deleteShop(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
