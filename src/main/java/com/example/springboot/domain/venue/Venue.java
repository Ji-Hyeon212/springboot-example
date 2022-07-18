package com.example.springboot.domain.venue;

import com.example.springboot.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity

public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    private String venueName;
    private String hallName;
    private Long totalSeat;
    private Long totalFloor;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

}
