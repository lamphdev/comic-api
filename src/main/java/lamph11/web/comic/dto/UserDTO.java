package lamph11.web.comic.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {

    private Long id;

    private String email;

    private String hashPassword;

    private String status;

    private Instant createdDate;

}
