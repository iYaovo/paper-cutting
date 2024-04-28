/**
 * Copyright (C), 2000-2024, XXX有限公司
 * FileName: Test
 * Author: 22932
 * Date: 2024/4/16 19:06:08
 * Description:
 * <p>
 * History:
 * <author> 作者姓名
 * <time> 修改时间
 * <version> 版本号
 * <desc> 版本描述
 */

import com.iyaovo.paper.admin.PaperAdminApplication;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Test
 * @Description: java类描述
 * @Author: 22932
 * @Date: 2024/4/16 19:06:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaperAdminApplication.class)

public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
//        ResourceEntity resourceEntity = new ResourceEntity();
//        resourceEntity.setResourceDescription("3213123");
//        resourceEntity.setResourceName("321");
//        redisUtils.setCacheObject("resourceKey",resourceEntity);
//        redisUtils.setCacheObject("yourKey", 321, 15, TimeUnit.MINUTES);
//        redisUtils.setCacheObject("yourKey", 3211, 15, TimeUnit.MINUTES);
//        redisUtils.deleteObject("321");


            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encode = passwordEncoder.encode("153426");
            System.out.println(encode);



    }
}
