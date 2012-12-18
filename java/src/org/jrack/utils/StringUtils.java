package org.jrack.utils;

/**
 * @author https://github.com/rack4java/rack4java-util/blob/master/src/org/rack4java/utils/StringUtils.java
 */
public class StringUtils {

    public static boolean isBlank(String s) {
        return s == null || s.length() == 0 || s.trim().equals("");
    }

    public static boolean isBlank(Object obj) {
        return obj == null || isBlank(obj.toString());
    }

    public static String stringValue(Object obj, String dfl) {
        return null != obj ? obj.toString() : dfl;
    }

    public static String stringValue(Object obj) {
        return stringValue(obj, "");
    }

    public static String nullToEmpty(Object obj) {
        return stringValue(obj, "");
    }
}