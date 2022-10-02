package krd.kurdistan.bootcamp.post;

import krd.kurdistan.bootcamp.comment.Comment;
import krd.kurdistan.bootcamp.common.BaseEntity;
import krd.kurdistan.bootcamp.like.Like;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Data
@Audited
public class Post extends BaseEntity {

    @NotNull
    private String title;

    @NotNull
    @Column(name = "post_limk")
    private String postLink;

    @NotNull
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
    List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
    List<Comment> comments;
}
