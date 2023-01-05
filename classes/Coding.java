package classes;

import util.Utilities;

public class Coding {
    private String day;
    private Integer[] platesEndingIn = new Integer[2];

    public Coding(String day, Integer[] platesEndingIn) {
        this.day = day;
        this.platesEndingIn = platesEndingIn;
    }

    public boolean isCoding(String day, Integer plateNumberEnd) {
        return this.day == day && Utilities.contains(platesEndingIn, plateNumberEnd);
    } 
}