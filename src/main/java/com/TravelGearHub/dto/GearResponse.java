package com.TravelGearHub.dto;

import lombok.Data;
@Data
public class GearResponse {
    private Long id;
    private String name;
    private String type;
    private String description;
    private double pricePerDay;
    private double depositAmount;
    private String location;
    private boolean available;
    private double averageRating;
    private String imageUrl;
    private String sellerName;
    private String sellerEmail;
}
