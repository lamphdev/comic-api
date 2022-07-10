package lamph11.web.comic.endpoint;

import lamph11.web.comic.common.ResponseUtils;
import lamph11.web.comic.dto.response.ApiResponse;
import lamph11.web.comic.dto.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ApiResponse> bindingExchangeException(WebExchangeBindException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ErrorDetail> errorDetails = bindingResult.getFieldErrors().stream().map(fieldError -> {
            ErrorDetail detail = new ErrorDetail();
            detail.setKey(fieldError.getField());
            detail.setErrorCode(fieldError.getCode());
            detail.setErrorMessage(fieldError.getDefaultMessage());
            return detail;
        }).collect(Collectors.toList());
        return Mono.just(ResponseUtils.wrap(errorDetails, "400", "Validate Exception"));
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Mono<ApiResponse> authenticationException(AuthenticationException e) {
        return Mono.just(ResponseUtils.wrap(null, "401", e.getMessage()));
    }

}
