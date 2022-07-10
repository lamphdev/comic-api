package lamph11.web.comic.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class RefreshTokenRequest {

    @NotEmpty
    @Length(max = 500)
    private String refreshToken;

}
