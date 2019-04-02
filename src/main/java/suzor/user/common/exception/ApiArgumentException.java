package suzor.user.common.exception;

/**
 * 请求参数校验异常
 */
public class ApiArgumentException extends Exception {
    public ApiArgumentException(String s) {
        super(s);
    }
}
