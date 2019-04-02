package suzor.user.common;

/**
 * web api 返回值类型
 */
public enum ApiResultCodeEnum {
    SUCCESS("100", "请求正常"), WARN("200", "受检异常"), FAIL("300", "系统异常");

    private final String code;
    private final String description;

    ApiResultCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
