package com.example.springboot.domain.venue;

import com.example.springboot.domain.review.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Venue")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Venue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private Long id;

    @Column(name = "venue_zipcode")
    private String zipcode;

    @Column(name = "venue_name")
    private String name;

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "venue_img")
    private String venueImg;

    private Long totalSeat;
    private Long totalFloor;

    @OneToMany(mappedBy = "venue")
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "seat_map", nullable = false, columnDefinition = "varchar")
    private String seatMap;

    @Builder
    public Venue(String zipcode, String name, String hallName, Long totalFloor, Long totalSeat, String seatMap){
        this.zipcode = zipcode;
        this.name = name;
        this.hallName = hallName;
        this.totalFloor = totalFloor;
        this.totalSeat = totalSeat;
        this.seatMap = seatMap;
    }
}
