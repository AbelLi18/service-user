package suzor.user.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import suzor.user.BaseTest;
import suzor.user.model.po.UserPO;

public class UserRepositoryTest extends BaseTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserId() {
        UserPO userPO = userRepository.findByUserId("49ab458c-5509-11e9-af04-0c96e69e1c71");
        System.err.println(userPO);
    }

    @Test
    public void insert() {
        UserPO userPO = new UserPO();
        userPO.setUsername("fczz");
        userRepository.insertThenGetId(userPO);
    }
}