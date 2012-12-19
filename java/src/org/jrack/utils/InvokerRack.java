package org.jrack.utils;

import org.jrack.Context;
import org.jrack.JRack;
import org.jrack.Rack;
import org.jrack.RackResponse;

public class InvokerRack extends JRack {
    public static final String DOT = ".";
    public static final String STAR = "*";
    public static final String ESCAPED_DOT = "\\" + DOT;
    private final String mask;

    public InvokerRack(String mask) {
        mask = mask.replace(DOT, ESCAPED_DOT);
        mask = mask.replace(STAR, DOT + STAR);
        this.mask = mask;
    }

    @Override
    public RackResponse call(Context<String> input) throws Exception {
        String clazz = input.get(Rack.PATH_INFO);
        clazz = getClasspathFromUrl(clazz);
        assertValidClass(clazz);
        JRack rack = getRack(clazz);
        return rack.call(input);
    }

    private String getClasspathFromUrl(String clazz) {
        int indexOf = clazz.lastIndexOf('/');
        if (indexOf != -1) {
            return clazz.substring(indexOf + 1);
        }
        return clazz;
    }

    private JRack getRack(String classpath) throws Exception {
        return (JRack) Class.forName(classpath).newInstance();
    }

    private void assertValidClass(String classpath) throws Exception {
        if (classpath != null && !classpath.matches(mask)) {
            throw new Exception(String.format("Invalid class [%s] for mask [%s]", classpath, mask));
        }
    }
}
