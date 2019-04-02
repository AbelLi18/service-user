package suzor.user.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import suzor.user.common.exception.ApiResultException;
import suzor.user.model.dto.UserDTO;
import suzor.user.model.po.UserPO;
import suzor.user.repository.UserRepository;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final Mapper dozerMapper;

    @Autowired
    public UserService(UserRepository userRepository, Mapper dozerMapper) {
        this.userRepository = userRepository;
        this.dozerMapper = dozerMapper;
    }

    @Cacheable(value = "user", key = "'userId'+'::'+#id")
    public UserDTO findByUserId(String id) throws ApiResultException {
        UserDTO userDTO = new UserDTO();
        UserPO userPO = userRepository.findByUserId(id);
        if (userPO == null) {
            throw new ApiResultException("未找到该用户");
        }
        dozerMapper.map(userPO, userDTO);
        return userDTO;
    }

    public UserDTO addUser(UserDTO user) {
        UserPO userPO = new UserPO();
        dozerMapper.map(user, userPO);
        try {
            userRepository.insertThenGetId(userPO);
        } catch (DuplicateKeyException e) {
            logger.debug(ExceptionUtils.getStackTrace(e));
            throw new RuntimeException("唯一性数据重复");
        }
        UserPO rs = userRepository.findById(userPO.getId());
        UserDTO rrs = new UserDTO();
        dozerMapper.map(rs, rrs);
        return rrs;
    }
}
