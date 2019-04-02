package suzor.user.model.dto;

import suzor.user.common.ApiResultCodeEnum;

public class ApiResultDTO<T> {
    private String resultCode = ApiResultCodeEnum.SUCCESS.getCode();
    private String errorMsg;
    private T data;

    public ApiResultDTO() {
    }

    public ApiResultDTO(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
