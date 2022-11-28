package bridge.util;

import bridge.exception.NumberInvalidException;

public class IntConverter {

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberInvalidException();
        }
    }
}
