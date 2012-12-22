package org.jrack.utils;

import org.jrack.Rack;

/**
 * @author https://github.com/rack4java/rack4java-util/blob/master/src/org/rack4java/utils/StringUtils.java
 * @author Florin
 */
public class StringUtils {

    public static boolean isBlank(String s) {
        return s == null || s.length() == 0 || s.trim().equals(Rack.EMPTY_STRING);
    }

    public static boolean isBlank(Object obj) {
        return obj == null || isBlank(obj.toString());
    }

    public static String stringValue(Object obj, String dfl) {
        return null != obj ? obj.toString() : dfl;
    }

    public static String stringValue(Object obj) {
        return stringValue(obj, Rack.EMPTY_STRING);
    }

    public static String nullToEmpty(Object obj) {
        return stringValue(obj, Rack.EMPTY_STRING);
    }

    /**
     * Convenience method to return a String array as a delimited (e.g. CSV)
     * String. E.g. useful for <code>toString()</code> implementations.
     *
     * @param arr   the array to display
     * @param delim the delimiter to use (probably a ",")
     * @return the delimited String
     */
    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if (arr == null || arr.length == 0) {
            return RackCache.EMPTY_STRING;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

}