package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lph_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq")
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

}
