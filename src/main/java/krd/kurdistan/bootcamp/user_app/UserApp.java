package krd.kurdistan.bootcamp.user_app;

import krd.kurdistan.bootcamp.comment.Comment;
import krd.kurdistan.bootcamp.common.BaseEntity;
import krd.kurdistan.bootcamp.follower.Follower;
import krd.kurdistan.bootcamp.following.Following;
import krd.kurdistan.bootcamp.like.Like;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class UserApp extends BaseEntity {

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "profile_image")
    private String profileImage;

    @NotNull
    private String bio;

    @NotNull
    @Column(name = "post_count")
    private Long postCount;

    @NotNull
    @Column(name = "follower_count")
    private Long followerCount;

    @NotNull
    @Column(name = "following_count")
    private Long followingCount;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userApp",cascade = CascadeType.ALL)
    List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userApp",cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userApp",cascade = CascadeType.ALL)
    List<Follower> followers;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userApp",cascade = CascadeType.ALL)
    List<Following> followings;

}
