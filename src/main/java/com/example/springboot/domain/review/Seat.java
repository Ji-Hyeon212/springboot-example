package com.example.springboot.domain.review;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Seat {
    private int floor;
    private String seat;
}
