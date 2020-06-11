package com.ds.algo.designpattern.structural.facade;

public class FacadeClient {
    public static void main(String[] args) {
        TravelPlanningFacade travelPlanningFacade = new TravelPlanningFacade(new Hotel(), new Flight(), new Restaurant());
        travelPlanningFacade.travel("Bangalore", "Las Vegas");
    }
}
