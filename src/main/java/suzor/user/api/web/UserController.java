package suzor.user.api.web;

import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import suzor.user.common.exception.ApiArgumentException;
import suzor.user.common.exception.ApiResultException;
import suzor.user.model.dto.ApiResultDTO;
import suzor.user.model.dto.SnakeCaseApiResultDTO;
import suzor.user.model.dto.SnakeCaseUserDTO;
import suzor.user.model.dto.UserDTO;
import suzor.user.service.UserService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
@Api(value = "用户API")
public class UserController {
    private final UserService userService;
    private final Mapper dozerMapper;

    @Autowired
    public UserController(UserService userService, Mapper dozerMapper) {
        this.userService = userService;
        this.dozerMapper = dozerMapper;
    }

    @ApiOperation(value = "获取用户的任务", notes = "获取用户的任务")
    @GetMapping("/userId/{userId}")
    public SnakeCaseApiResultDTO<SnakeCaseUserDTO> findByUserId(@NotNull @PathVariable String userId) throws ApiArgumentException, ApiResultException {
        if (Strings.isNullOrEmpty(userId) || userId.length() != 32) {
            throw new ApiArgumentException("参数校验错误，userId 不符合要求");
        }
        UserDTO userDTO = userService.findByUserId(userId);
        SnakeCaseUserDTO snakeCaseUserDTO = new SnakeCaseUserDTO();
        dozerMapper.map(userDTO, snakeCaseUserDTO);
        return new SnakeCaseApiResultDTO<>(snakeCaseUserDTO);
    }

    @PostMapping("/add")
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
