package models;

import java.util.*;

public class BeerStorage {
    public static Map<Integer, Beer> beerList;
    static {
        beerList = new HashMap<>();
        Beer guinness = new Beer("Guinness", 4.3);
        Beer simcoe = new Beer("Simcoe", 6.7);

        beerList.put(guinness.id, guinness);
        beerList.put(simcoe.id, simcoe);
    }
}