/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: ImageToBase64Util
 * Author: 22932
 * Date: 2024/5/8 15:10:06
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.common.util;

/**
 * @ClassName: ImageToBase64Util
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 15:10:06
 */
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;



public class ImageToBase64Util {
   public static String convertFileToBase64(String imgPath) {
      // 读取图片字节数组
      byte[] data = null;
      try (InputStream in = new FileInputStream(imgPath)) {
         // 使用BufferedInputStream来缓冲读取，提高性能
         try (BufferedInputStream bis = new BufferedInputStream(in)) {
            // 不使用in.available()，因为它可能返回不准确的字节数
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
               baos.write(buffer, 0, bytesRead);
            }
            data = baos.toByteArray();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      // 对字节数组进行Base64编码，得到Base64编码的字符串
      // 使用 Java 8 及以上版本的内置 Base64 编码功能
      return Base64.encodeBase64String(data);
   }
}

