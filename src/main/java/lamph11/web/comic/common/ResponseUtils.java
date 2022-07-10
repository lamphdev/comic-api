package lamph11.web.comic.common;

import lamph11.web.comic.dto.response.ApiResponse;

public class ResponseUtils {

    public static <T> ApiResponse<T> wrap(T data, String status, String message) {
        ApiResponse<T> response = new ApiResponse();
        response.setCode(status);
        response.setMessage(message);
        response.setBody(data);
        return response;
    }

    public static <T> ApiResponse<T> wrap(T data, String message) {
        return wrap(data, "200", "OK");
    }

    public static <T> ApiResponse<T> wrap(T data) {
        return wrap(data, "200", "OK");
    }

}
