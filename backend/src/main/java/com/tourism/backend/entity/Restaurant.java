package com.tourism.backend.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long minPrice;

    @Column(nullable = false)
    private Long maxPrice;

    @Column(nullable = false)
    private String cuisine;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private Boolean isActive = true;
}
