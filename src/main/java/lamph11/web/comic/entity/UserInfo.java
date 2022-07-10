package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "lph_user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String hashPassword;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant createdDate;

}
