package krd.kurdistan.bootcamp.comment;


import krd.kurdistan.bootcamp.common.BaseEntity;
import krd.kurdistan.bootcamp.post.Post;
import krd.kurdistan.bootcamp.user_app.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_comment")
@Data
@Audited
public class Comment extends BaseEntity {

    @NotNull
    @Column(name = "date")
    private Date date;


    @NotNull
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
