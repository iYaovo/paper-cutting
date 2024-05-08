/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ResourceServiceImpl
 * Author: 22932
 * Date: 2024/5/8 11:08:09
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.foreground.service.impl;

import cn.hutool.core.date.DateUtil;
import com.iyaovo.paper.common.constant.Constants;
import com.iyaovo.paper.common.exception.Asserts;
import com.iyaovo.paper.common.util.ImageToBase64Util;
import com.iyaovo.paper.common.util.RandomUtil;
import com.iyaovo.paper.foreground.domain.vo.ResourceVo;
import com.iyaovo.paper.foreground.service.IResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @ClassName: ResourceServiceImpl
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 11:08:09
 */
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements IResourceService {

    @Override
    public ResourceVo addResource(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String imagePath = null;
        if(suffixName.equals(".jpg") || suffixName.equals(".png")){
            imagePath ="Image\\";
        }else {
            Asserts.fail("文件格式错误!");
        }
        //重新生成文件名
        Date date = new Date();
        String fileName1 = DateUtil.format(date,"yyyy-MM-dd")+ RandomUtil.createCode(4);
        String fileName2 = fileName1 + suffixName;
        try {
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(new File(Constants.RESOURCE_PATH +imagePath + fileName2)));
            out.write(file.getBytes());
            out.flush();
            out.close();

            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setResourcePath(imagePath+fileName2);
            resourceVo.setResourceBase64(ImageToBase64Util.convertFileToBase64(Constants.RESOURCE_PATH+imagePath + fileName2));
            return resourceVo;
        } catch (Exception e) {
            e.printStackTrace();
            Asserts.fail("添加图片失败！");
            return null;
        }
    }
}

