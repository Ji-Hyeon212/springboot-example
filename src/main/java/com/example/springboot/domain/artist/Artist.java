package com.example.springboot.domain.artist;

import com.example.springboot.domain.review.Review;
import com.example.springboot.domain.show.Show;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Artist")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    @Column(name = "artist_name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "artist")
    private List<Show> shows = new ArrayList<>();

    @Builder
    public Artist(String name){
        this.name = name;
    }
}
