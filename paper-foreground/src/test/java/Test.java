/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: Test
 * Author: 22932
 * Date: 2024/4/14 00:24:56
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */

import com.iyaovo.paper.foreground.PaperForegroundApplication;
import com.iyaovo.paper.foreground.mapper.DailySignMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * @ClassName: Test
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/14 00:24:56
 */
@SpringBootTest(classes = PaperForegroundApplication.class)
@RunWith(SpringRunner.class)
public class Test {
   @Autowired
   private DailySignMapper dailySignMapper;

   @org.junit.Test
   public void test(){
      System.out.println(dailySignMapper.selectList(null));
   }

}

