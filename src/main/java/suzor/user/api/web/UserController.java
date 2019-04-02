package suzor.user.api.web;

import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import suzor.user.common.exception.ApiArgumentException;
import suzor.user.common.exception.ApiResultException;
import suzor.user.model.dto.ApiResultDTO;
import suzor.user.model.dto.UserDTO;
import suzor.user.service.UserService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
@Api(value = "用户相关API", tags = {"用户"})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userId/{userId}")
    @ApiOperation(value = "根据用户ID查询用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String")
    public ApiResultDTO<UserDTO> findByUserId(@NotNull @PathVariable String userId) throws ApiArgumentException, ApiResultException {
        if (Strings.isNullOrEmpty(userId) || userId.length() != 32) {
            throw new ApiArgumentException("参数校验错误，userId 不符合要求");
        }
        return new ApiResultDTO<>(userService.findByUserId(userId));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增用户")
    public ApiResultDTO<UserDTO> addUser(@RequestBody UserDTO user) throws ApiArgumentException {
        if (user == null) {
            throw new ApiArgumentException("参数校验错误，user 不能为空");
        }
        try {
            return new ApiResultDTO<>(userService.addUser(user));
        } catch (Exception e) {
            throw new RuntimeException("新增用户失败");
        }
    }
}
