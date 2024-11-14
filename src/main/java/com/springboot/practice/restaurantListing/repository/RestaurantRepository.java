package com.springboot.practice.restaurantListing.repository;

import com.springboot.practice.restaurantListing.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository
        extends JpaRepository<Restaurant,Integer> {
}
