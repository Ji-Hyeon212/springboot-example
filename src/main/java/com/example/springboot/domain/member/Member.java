package com.example.springboot.domain.member;

import com.example.springboot.domain.review.Review;
import com.example.springboot.domain.scrap.Scrap;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

enum Height{
    HEIGHT, SITHEIGHT
}

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String memberName;
    private String memberNickName;
    private Integer memberAge;

    @Column(name = "gender", columnDefinition = "char")
    private String gender;

    @Enumerated(EnumType.ORDINAL)
    private Height standHeight = Height.HEIGHT;
    private Height sitHeight = Height.SITHEIGHT;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();
    @OneToMany
    private List<Scrap> scraps = new ArrayList<>();

    @Builder
    public Member(String memberName, String memberNickName, Integer memberAge, String gender, Height standHeight, Height sitHeight){
        this.memberName = memberName;
        this.memberNickName = memberNickName;
        this.memberAge = memberAge;
        this.gender = gender;
        this.standHeight = standHeight;
        this.sitHeight = sitHeight;
    }

}
