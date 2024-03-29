package com.example.springboot.domain.member;

import com.example.springboot.domain.review.Review;
import com.example.springboot.domain.scrap.Scrap;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false, length = 50, columnDefinition = "varchar")
    private String id;

    @Column(name = "member_name", nullable = false, length = 50, columnDefinition = "nvarchar")
    private String name;

    @Column(name = "nickname", nullable = false, unique = true, length = 50, columnDefinition = "nvarchar")
    private String nickName;

    @Column(name = "email", unique = true, length = 50, columnDefinition = "varchar")
    private String email;

    @Column(name = "birthday", columnDefinition = "LocalDate")
    private Integer birthday;

    @Column(name = "gender", columnDefinition = "char")
    private String gender;

    @Column(name = "glasses", columnDefinition = "boolean")
    private boolean wearGlasses;

    @Column(name = "standing_height")
    private int standingHeight;
    
    @Column(name = "sitting_height", columnDefinition = "String")
    private SittingHeight sittingHeight;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Scrap> scraps = new ArrayList<>();

    @Builder
    public Member(String name, String nickName, String email){
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }
}
