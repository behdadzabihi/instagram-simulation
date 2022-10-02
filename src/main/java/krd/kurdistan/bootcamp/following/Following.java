package krd.kurdistan.bootcamp.following;


import krd.kurdistan.bootcamp.common.BaseEntity;
import krd.kurdistan.bootcamp.user_app.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_following")
@Data
@Audited
public class Following extends BaseEntity {

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "profile_image")
    private String profileImage;

    @NotNull
    @Column(name = "remove_following")
    private Boolean removeFromFallowingList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;
}
