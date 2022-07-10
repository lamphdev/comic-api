package lamph11.web.comic.dto;

import lombok.Data;

@Data
public class ErrorDetail {

    private String key;
    private String errorCode;
    private String errorMessage;
}
