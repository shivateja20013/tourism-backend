package com.tourism.backend.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String activityName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isActive = true;
}
