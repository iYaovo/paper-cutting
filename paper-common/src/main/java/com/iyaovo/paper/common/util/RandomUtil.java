/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: RandomUtils
 * Author: 22932
 * Date: 2024/5/8 11:26:19
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */
package com.iyaovo.paper.common.util;

import java.util.Random;

/**
 * @ClassName: RandomUtils
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/5/8 11:26:19
 */
public class RandomUtil {
   public static String createCode(int n ){
      // 1、定义可能出现的字符信息
      String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456";

      // 2、循环n次，每次生成一个随机的索引，提取相应的字符连接起来即可
      String code = "";
      Random r = new Random();
      for (int i = 0; i < n; i++) {
         // 随机获得一个索引
         int index = r.nextInt(data.length());
         char c = data.charAt(index);
         code+=c;
      }
      // 3、输出生成的字符串
      return code;
   }
}

