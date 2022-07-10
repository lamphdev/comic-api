package lamph11.web.comic.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

    @NotEmpty
    @Length(max = 200)
    private String username;

    @NotEmpty
    @Length(max = 100)
    private String password;

}
