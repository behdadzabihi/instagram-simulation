package krd.kurdistan.bootcamp.like;

import krd.kurdistan.bootcamp.common.BaseEntity;
import krd.kurdistan.bootcamp.post.Post;
import krd.kurdistan.bootcamp.user_app.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Like extends BaseEntity {

    @NotNull
    private Boolean isFavorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
