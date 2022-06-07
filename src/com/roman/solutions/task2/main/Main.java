package com.roman.solutions.task2.main;

import com.roman.solutions.task2.city.City;
import com.roman.solutions.task2.sourcedata.CitiesList;
import com.roman.solutions.task2.travelagent.TravelAgent;
import com.roman.solutions.task2.trip.Trip;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type start city: ");
        String start = scanner.nextLine();
        System.out.print("Type finish city: ");
        String finish = scanner.nextLine();




        ArrayList<City> cities = CitiesList.citiesFromFile("sourcedata/cities.txt");

        // String start = "gdansk";
        // String finish = "warszawa";



        Trip newTrip = new Trip();
        newTrip.addCity(City.findCityByName(start, cities));

        TravelAgent travelAgency = new TravelAgent(cities);
        travelAgency.addTrip(start, finish, newTrip);


        travelAgency.minCost();

    }
}
