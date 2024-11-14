package com.springboot.practice.restaurantListing.service;

import com.springboot.practice.restaurantListing.dto.RestaurantDTO;
import com.springboot.practice.restaurantListing.entity.Restaurant;
import com.springboot.practice.restaurantListing.mapper.RestaurantMapper;
import com.springboot.practice.restaurantListing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurantList =
                restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOListList = restaurantList.stream().
                map(restaurant -> RestaurantMapper.Instance.mapRestaurantToRestaurantDTo(restaurant))
                .collect(Collectors.toList());
        return restaurantDTOListList;
    }

    public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant =
                RestaurantMapper.Instance.mapRestaurantDTOToRestaurant(restaurantDTO);
        Restaurant savedrestaurant = restaurantRepository.save(restaurant);
        RestaurantDTO savedrestaurantDTO =
                RestaurantMapper.Instance.mapRestaurantToRestaurantDTo
                        (savedrestaurant);
        return savedrestaurantDTO;
    }

    public ResponseEntity<RestaurantDTO> findRestaurantById(Integer id) {

        Optional<Restaurant> restaurant =
                restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            RestaurantDTO foundRestaraunt =
                    RestaurantMapper.Instance.mapRestaurantToRestaurantDTo(restaurant.get());
            return new ResponseEntity<>(foundRestaraunt, HttpStatus.FOUND);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}