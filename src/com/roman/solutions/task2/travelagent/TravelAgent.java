package com.roman.solutions.task2.travelagent;

import com.roman.solutions.task2.city.City;
import com.roman.solutions.task2.trip.Trip;

import java.util.ArrayList;

public class TravelAgent {
    private ArrayList<City> cities;
    private ArrayList<Trip> trips;

    public TravelAgent(ArrayList<City> cities){
        this.cities = cities;
        this.trips = new ArrayList<>();
    }


    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }


     // This method adds all possible trips to the bd or TripsList
     // start This is start-city
     // finish This is finish-city
     // trip This is one of the routes


    public void addTrip (String start, String finish, Trip trip) {

        if (!cities.contains(City.findCityByName(start, cities))||!cities.contains(City.findCityByName(finish, cities))) {
            System.out.println("This is an unknown city");
            return;
        }

        if ((start!=null)&&(start.equals(finish))) {
            getTrips().add(trip);
        }

        City startCity = null;
        for (City city: cities) {
            if (city.getName().equals(start)) {
                startCity = city;
            }
        }

        for (int idCity: startCity.getCostMap().keySet()){
            if (trip.getVisitedCities().contains(City.findCityById(idCity, cities))) {
                continue;
            }

            City nextCity = City.findCityById(idCity, cities);

            Trip newTrip = new Trip(trip);
            newTrip.addCost(startCity.getCostMap().get(idCity));
            newTrip.addCity(nextCity);

            addTrip(nextCity.getName(), finish, newTrip);
        }
    }


     // This method choosing the minimum cost


    public void minCost(){
        if(this.getTrips().size()==0) return;
        int minCost = this.getTrips().get(0).getTotalCost();
        Trip cheapTrip = null;
        for(Trip trip: this.getTrips()){
            if (trip.getTotalCost()<=minCost) {
                minCost = trip.getTotalCost();
                cheapTrip = trip;
            }
        }
        if (cheapTrip != null){
            System.out.print("Route: ");
            for (City city: cheapTrip.getVisitedCities()){
                System.out.printf("%s  ",city.getName());
            }
            System.out.printf("\nMin Cost: %d",minCost);
        }

    }
}
