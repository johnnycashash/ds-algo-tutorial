package com.ds.algo.designpattern.structural.facade;

public class TravelPlanningFacade {
    Hotel hotel;
    Flight flight;
    Restaurant restaurant;

    public TravelPlanningFacade(Hotel hotel, Flight flight, Restaurant restaurant) {
        this.hotel = hotel;
        this.flight = flight;
        this.restaurant = restaurant;
    }

    public void travel(String source, String destination) {
        flight.bookFlight(source, destination);
        hotel.bookHotel(destination);
        restaurant.bookAnyFamousRestaurant();
        flight.bookFlight(destination, source);
    }
}
