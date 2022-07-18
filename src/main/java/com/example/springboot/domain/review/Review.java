package com.example.springboot.domain.review;

import com.example.springboot.domain.artist.Artist;
import com.example.springboot.domain.show.Show;
import com.example.springboot.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

enum Seat{
    FLOOR, SEAT
}

@Getter
@NoArgsConstructor
@Entity

public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private LocalDateTime writeTime;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member writer;

    @Enumerated(EnumType.ORDINAL) //1(층)
    private Seat floor = Seat.FLOOR;
    @Enumerated(EnumType.STRING) //A15
    private Seat seat = Seat.SEAT;

    @ManyToOne
    @JoinColumn(name = "showId")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    private Float evaluation;

//    private List<String> pictures = new ArrayList<>;

    @Builder
    public Review(Seat floor, Seat seat, Float evaluation){
        this.floor = floor;
        this.seat = seat;
        this.evaluation = evaluation;
    }

}
