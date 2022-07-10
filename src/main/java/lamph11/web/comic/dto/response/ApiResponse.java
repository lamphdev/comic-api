package lamph11.web.comic.dto.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String code;
    private String message;
    private T body;
}
