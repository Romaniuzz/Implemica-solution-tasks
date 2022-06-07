package com.roman.solutions.task2.sourcedata;

import com.roman.solutions.task2.city.City;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CitiesList {

     // This method returns CitiesList from file on disk
     // input This is the path to the cities file

    public static ArrayList<City> citiesFromFile(String input){
        File inputFile = new File(input);
        ArrayList<City> cities = new ArrayList<>();
        City city = null;
        String cityInfo = null;
        try (BufferedReader bRead = new BufferedReader(new FileReader(inputFile))){
            while ((cityInfo = bRead.readLine()) != null){
                String[] cityInfoArr = cityInfo.split(" ");
                city = new City(Integer.parseInt(cityInfoArr[0]), cityInfoArr[1], Integer.parseInt(cityInfoArr[2]));
                int b = 0;
                for (int i=0;i<city.getNeighbors();i++){
                    city.put(Integer.parseInt(cityInfoArr[3+b]), Integer.parseInt(cityInfoArr[4+b]));
                    b = b+2;
                }
                cities.add(city);
            }

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return cities;
    }
}
