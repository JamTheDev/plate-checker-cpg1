package classes;

import enums.Days;
import enums.Errors;
import enums.Places;
import util.Utilities;

public class CarInformation {

    private String plateNumber, day, place;
    private Errors error = Errors.NONE;
    private int time;

    public CarInformation(String plateNumber, String day, String place, int time) {
        this.plateNumber = plateNumber;
        this.day = day;
        this.place = place;
        this.time = time;
    }

    public String[] getPlateNumber() {
        return this.plateNumber.split(" ");
    }

    public boolean getCodingStatus() {

        Integer lastPlateNumber;

        // if the program cannot parse it, it means that the submitted
        // plate number is invalid, hence throwing an error and will
        // result in the method returning a false.
        try {
            lastPlateNumber = Integer.parseInt(String.valueOf(getPlateNumber()[1].charAt(2)));
            Integer.parseInt(String.valueOf(getPlateNumber()[1]));
        } catch (Exception e) {
            System.out.println("Invalid plate number!");
            error = Errors.INVALID_PLATE_NO;
            return false;
        }


        // in this portion of the program, it will iterate through the Days enum
        // remember that each value in this enum has a size of 3 where:
        //
        // index 0 = day
        // index 1 & 2 = plates available for the day
        for (Coding day : Days.days) {
            // conditions can be stored in a boolean variable
            // so we are going to store this to clean up our code.
            // but the summary of this code is that, it just checks if the last number
            // of our plate given matches the 2 given values in index.

            // should be self-explanatory
            if (day.isCoding(this.day, lastPlateNumber) && Utilities.contains(Places.places, this.place)) {

                // if the coding is in makati or pasay...
                // siguro naman self-explanatory na 'to
                if (this.place.equalsIgnoreCase("makati") || this.place.equalsIgnoreCase("pasay")) {
                    return time >= 700 && time <= 2059;
                }
                
                // this too... HAHAHAAHHA
                return time >= 1501 && time <= 2059;
            }
        }

        return false;
    }

    public void printCarInformation() {
        System.out.println(
                "Plate Number: " + plateNumber + "\n" +
                        "Day: " + day + "\n" +
                        "Place: " + place + "\n" +
                        "Time: " + time + "\n" +
                        "Status: " + (getCodingStatus() ? "CODING" : "NOT CODING") + "\n");
    }
}
