package com.springboot.practice.restaurantListing.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
