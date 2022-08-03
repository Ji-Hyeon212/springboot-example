package com.example.springboot.domain.show;

import com.example.springboot.domain.artist.Artist;
import com.example.springboot.domain.review.Evaluation;
import com.example.springboot.domain.review.Review;
import com.example.springboot.domain.review.Seat;
import com.example.springboot.domain.venue.Venue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Show")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_name")
    private String name;

    @Column(name = "show_poster")
    private String poster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Embedded
    private TimeInfo timeInfo;

    @OneToMany(mappedBy = "show")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Show(String name, Venue venue, Artist artist, TimeInfo timeInfo){
        this.name = name;
        this.venue = venue;
        this.artist = artist;
        this.timeInfo = timeInfo;
    }
}
