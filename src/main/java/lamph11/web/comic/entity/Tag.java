package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lph_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq", sequenceName = "tag_seq")
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

}
