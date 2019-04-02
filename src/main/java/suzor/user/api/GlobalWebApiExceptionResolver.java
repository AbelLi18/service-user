package suzor.user.api;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import suzor.user.common.ApiResultCodeEnum;
import suzor.user.common.exception.ApiArgumentException;
import suzor.user.common.exception.ApiResultException;
import suzor.user.model.dto.ApiResultDTO;

@RestControllerAdvice
public class GlobalWebApiExceptionResolver {
    private final Logger logger = LoggerFactory.getLogger(GlobalWebApiExceptionResolver.class);

    /**
     * 处理业务异常
     */
    @ExceptionHandler({ApiArgumentException.class, ApiResultException.class})
    public ApiResultDTO<Object> handleBusinessException(Exception e) {
        logger.debug("用户请求出现预期内错误:{}", e.getMessage());
        ApiResultDTO<Object> apiResultDTO = new ApiResultDTO<>();
        apiResultDTO.setResultCode(ApiResultCodeEnum.WARN.getCode());
        apiResultDTO.setErrorMsg(e.getMessage());
        return apiResultDTO;
    }

    /**
     * 处理不可预料的系统异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResultDTO<Object> handleException(Exception e) {
        logger.error("用户请求出现不可预知的错误：\n{}", ExceptionUtils.getStackTrace(e));
        ApiResultDTO<Object> apiResultDTO = new ApiResultDTO<>();
        apiResultDTO.setResultCode(ApiResultCodeEnum.FAIL.getCode());
        apiResultDTO.setErrorMsg(ApiResultCodeEnum.FAIL.getDescription());
        return apiResultDTO;
    }
}
