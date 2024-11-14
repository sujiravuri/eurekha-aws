package com.springboot.practice.restaurantListing.controller;

import com.springboot.practice.restaurantListing.dto.RestaurantDTO;
import com.springboot.practice.restaurantListing.entity.Restaurant;
import com.springboot.practice.restaurantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/findallrestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){

        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<RestaurantDTO> saveRestaurant
            (@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO addedrestaurant =
                restaurantService.saveRestaurant(restaurantDTO);
        return new ResponseEntity<>(addedrestaurant,HttpStatus.CREATED);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById
            (@PathVariable Integer id )
    {
        return restaurantService.findRestaurantById(id);
    }

}
