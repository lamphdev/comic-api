package lamph11.web.comic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lph_tag_post")
public class TagPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_post_seq")
    @SequenceGenerator(name = "tag_post_seq", sequenceName = "tag_post_seq")
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public TagPost(Tag tag, Post post) {
        this.tag = tag;
        this.post = post;
    }
}
