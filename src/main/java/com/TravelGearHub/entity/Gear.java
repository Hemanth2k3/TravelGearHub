package com.TravelGearHub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gears")
public class Gear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // "Camera", "Jacket", "Tent", etc.

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private double pricePerDay;

    private double depositAmount;

    private String location; // City or pickup address

    private boolean available = true; // Is gear currently available for rent?

    private double averageRating = 0.0;

    private String imageUrl; // Optional image of gear

    private boolean isActive = true; // For admin or seller deactivation

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller; // who owns this gear

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
