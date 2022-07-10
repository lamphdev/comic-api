package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "lph_series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "series_seq")
    @SequenceGenerator(name = "series_seq", sequenceName = "series_seq")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 2000)
    private String content;

    @Column(nullable = false)
    private Integer complete;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant createdDate;

    @Column(nullable = false)
    private Instant updatedDate;

}
