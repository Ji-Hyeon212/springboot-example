package com.example.springboot.domain.show;

import com.example.springboot.domain.artist.Artist;
import com.example.springboot.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

enum Dateinfo{
    START, END
}

@Getter
@NoArgsConstructor
@Entity

public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    @Enumerated(EnumType.STRING)
    private Dateinfo startDate = Dateinfo.START;
    private Dateinfo endDate = Dateinfo.END;

    private String timeInfo;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();
}
