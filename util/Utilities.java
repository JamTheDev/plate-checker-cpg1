package util;

public class Utilities {

    public static boolean contains(Object[] objects, Object condition) {
        for (Object object : objects) {
            if (condition == object) {
                return true;
            }
        }

        return false;
    }

}