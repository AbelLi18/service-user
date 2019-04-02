package suzor.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import suzor.user.BaseTest;
import suzor.user.common.exception.ApiResultException;
import suzor.user.model.dto.UserDTO;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() throws ApiResultException {
        UserDTO dto = userService.findByUserId("a4db6cb5-5512-11e9-af04-0c96e69e1c71");
        System.err.println(dto);
    }

    @Test
    public void addUser() {
        UserDTO dto = new UserDTO();
        dto.setUsername("fzzzz");
        UserDTO rs = userService.addUser(dto);
        System.err.println(rs);
    }
}