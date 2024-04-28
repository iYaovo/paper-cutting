package com.iyaovo.paper.admin.controller;

import com.iyaovo.paper.admin.domain.dto.ShopInfoParam;
import com.iyaovo.paper.admin.domain.entity.ShopInfo;
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
//public class PmsBrandController {
public class ShopController {

//    private final PmsBrandService brandService;
    private final IShopInfoService iShopInfoService;

    @Operation(summary = "获取全部店铺列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
//    public CommonResult<List<PmsBrand>> getList() {
//        return CommonResult.success(brandService.listAllBrand());
//    }
    public CommonResult<List<ShopInfo>> getList() {
        return CommonResult.success(iShopInfoService.listAllShop());
    }

    @Operation(summary = "添加店铺")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public CommonResult create(@Validated @RequestBody PmsBrandParam pmsBrand) {
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
    public CommonResult update(@PathVariable("id") Long id,
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
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = iShopInfoService.deleteShop(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @Operation(summary = "根据店铺名称分页获取店铺列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<ShopInfo>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<ShopInfo> shopInfoList = iShopInfoService.listShop(keyword,pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(shopInfoList));
    }

//    @Operation(summary = "根据编号查询品牌信息")
//    @PostMapping(value = "/{id}")
//    public CommonResult<PmsBrand> getItem(@PathVariable("id") Long id) {
//        return CommonResult.success(brandService.getBrand(id));
//    }

    @Operation(summary = "批量删除店铺")
    @PostMapping(value = "/delete/batch")
    public CommonResult deleteBatch(@RequestParam("ids") List<Long> ids) {
        int count = iShopInfoService.deleteShop(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

//    @Operation(summary = "批量更新显示状态")
//    @PostMapping(value = "/update/showStatus")
//    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids,
//                                   @RequestParam("showStatus") Integer showStatus) {
//        int count = brandService.updateShowStatus(ids, showStatus);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }

//    @Operation(summary = "批量更新厂家制造商状态")
//    @PostMapping(value = "/update/factoryStatus")
//    public CommonResult updateFactoryStatus(@RequestParam("ids") List<Long> ids,
//                                      @RequestParam("factoryStatus") Integer factoryStatus) {
//        int count = brandService.updateFactoryStatus(ids, factoryStatus);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}
