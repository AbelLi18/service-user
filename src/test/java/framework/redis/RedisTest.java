package framework.redis;

import framework.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest extends BaseTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void addTest() {
        stringRedisTemplate.opsForValue().set("example::string", "hello world");
    }
}
