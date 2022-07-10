package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "lph_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "post_seq")
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(length = 300)
    private String seoPath;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant createdDate;

    @Column(nullable = false)
    private Instant updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private Series series;

}
