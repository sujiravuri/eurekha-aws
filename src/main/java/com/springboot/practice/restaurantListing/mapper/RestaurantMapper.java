package com.springboot.practice.restaurantListing.mapper;

import com.springboot.practice.restaurantListing.dto.RestaurantDTO;
import com.springboot.practice.restaurantListing.entity.Restaurant;
import jakarta.ws.rs.SeBootstrap;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper Instance = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTo(Restaurant restaurant);


}
