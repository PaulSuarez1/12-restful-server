package models;

public class Beer {
    private static int ID_COUNT = 12_543;

    public int id;
    public String name;
    public float abv;
    // I should put more things here for fun

    public Beer(String name, float abv) {
        this.id = ID_COUNT++;
        this.name = name;
        this.abv = abv;
    }

    public String toString() {
        return this.name + " is " + this.abv + "%";
    }
}
