package util;

public class Utilities {

    public static boolean contains(String[] strings, String condition) {
        for (String object : strings) {
            if (object.equalsIgnoreCase(condition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Integer[] ints, Integer condition) {
        for (Integer object : ints) {
            if (condition == object) {
                return true;
            }
        }
        return false;
    }
}