package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "lph_social_info", uniqueConstraints = {
        @UniqueConstraint(name = "social_info_unique", columnNames = {"provider", "identify"})
})
public class SocialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_seq")
    @SequenceGenerator(name = "social_seq", sequenceName = "social_seq")
    private Long id;

    @Column(length = 50, nullable = false)
    private String provider;

    @Column(length = 200, nullable = false)
    private String identify;

    @Column(nullable = false)
    private Instant createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo userInfo;

}
