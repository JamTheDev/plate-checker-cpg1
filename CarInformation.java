import enums.Days;
import enums.Errors;

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

        char lastPlateNumber = getPlateNumber()[1].charAt(2);

        // it will try to first parse the number part of the plate.
        // if it cannot parse it, it means that the submitted
        // plate number is invalid, hence throwing an error and will
        // result in the method returning a false.
        try {
            Integer.parseInt(String.valueOf(lastPlateNumber));
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
        for (String[] day : Days.days) {
            // conditions can be stored in a boolean variable
            // so we are going to store this to clean up our code.
            // but the summary of this code is that, it just checks if the last number
            // of our plate given matches the 2 given values in index.
            boolean validPlateNumber = day[1].equals(String.valueOf(lastPlateNumber))
                    || day[2].equals(String.valueOf(lastPlateNumber));

            // should be self-explanatory
            if (day[0].equals(this.day) && validPlateNumber) {

                // if the coding is in makati or pasay...
                // siguro naman self-explanatory na 'to
                if (this.place.toLowerCase().equalsIgnoreCase("makati") || this.place.equalsIgnoreCase("pasay")) {
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
