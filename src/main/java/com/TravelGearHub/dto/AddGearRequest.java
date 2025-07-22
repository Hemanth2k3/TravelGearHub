package com.TravelGearHub.dto;

import lombok.Data;

@Data
public class AddGearRequest {
    private String name;
    private String type;
    private String description;
    private double pricePerDay;
    private double depositAmount;
    private String location;
    private String imageUrl;
    private Long sellerId; // TEMP field until auth is added
}
