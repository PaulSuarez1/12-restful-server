package models;

import java.util.*;

public class BeerStorage {
    public static Map<Integer, Beer> beerList;
    static {
        beerList = new HashMap<>();
        Beer guinness = new Beer("Guinness", (float) 4.3);
        Beer simcoe = new Beer("Simcoe", (float) 6.7);
        Beer headyTopper = new Beer("Heady Topper", (float) 8.1);
        Beer veryHazy = new Beer("Very Hazy", (float) 8.6);

        beerList.put(guinness.id, guinness);
        beerList.put(simcoe.id, simcoe);
        beerList.put(headyTopper.id, headyTopper);
        beerList.put(veryHazy.id, veryHazy);
    }
}