package com.ds.algo.designpattern.structural.facade;

/**
 * Facade Pattern – provides a simplified interface to a complex subsystem.
 *
 * KEY IDEA: Client calls ONE method (travel()), Facade orchestrates
 *           multiple subsystem calls (Flight, Hotel, Restaurant).
 *
 * Real-world: Spring's JdbcTemplate is a facade over raw JDBC.
 */
public class TravelPlanningFacade {
    private final Hotel hotel;
    private final Flight flight;
    private final Restaurant restaurant;

    public TravelPlanningFacade(Hotel hotel, Flight flight, Restaurant restaurant) {
        this.hotel = hotel;
        this.flight = flight;
        this.restaurant = restaurant;
    }

    /** One simple call hides all the complexity. */
    public void travel(String source, String destination) {
        flight.bookFlight(source, destination);
        hotel.bookHotel(destination);
        restaurant.bookAnyFamousRestaurant();
        flight.bookFlight(destination, source);  // return flight
    }
}
