package suzor.user.common.exception;

/**
 * 返回值不在预期内异常
 */
public class ApiResultException extends Exception {
    public ApiResultException(String s) {
        super(s);
    }
}
