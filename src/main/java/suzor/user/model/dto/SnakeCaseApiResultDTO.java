package suzor.user.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SnakeCaseApiResultDTO<T> extends ApiResultDTO<T> {

    public SnakeCaseApiResultDTO() {
    }

    public SnakeCaseApiResultDTO(T data) {
        super(data);
    }

    @Override
    public T getData() {
        return super.getData();
    }

    @Override
    public void setData(T data) {
        super.setData(data);
    }
}
