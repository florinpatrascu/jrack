package org.jrack;

import java.io.File;
import java.nio.charset.Charset;

public interface RackBody {
    enum Type { file, literal }

    Type getType();

    File getBodyAsFile();
    Iterable<String> getBodyAsStrings();
    Iterable<byte[]> getBodyAsBytes();
    byte[] getBytes();
    byte[] getBytes(String charset);

}