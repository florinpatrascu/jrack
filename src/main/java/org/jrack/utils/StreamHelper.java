package org.jrack.utils;

import org.jrack.Context;
import org.jrack.Rack;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class StreamHelper {

    private static final int BUFFER_SIZE = 4096;

    public static byte[] readAsBytes(InputStream in, long maxSize) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            int byteCount = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = 0;

            while ((byteCount < maxSize) && (bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return out.toByteArray();
        } finally {
            try {
                if (null != in) in.close();
            } catch (IOException ignored) {
            }
            try {
                out.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static byte[] readAsBytes(InputStream in) throws IOException {
        return readAsBytes(in, Long.MAX_VALUE);
    }

    public static String readAsString(InputStream in) throws IOException {
        return new String(readAsBytes(in));
    }

    public static String readAsString(InputStream in, long length) throws IOException {
        return new String(readAsBytes(in, length));
    }

    public static String readAsString(InputStream in, Charset charset) throws IOException {
        return new String(readAsBytes(in), charset);
    }

    public static String readAsString(InputStream in, long length, Charset charset) throws IOException {
        return new String(readAsBytes(in, length), charset);
    }

    public static String readRequestBodyAsString(Context<String> environment) throws IOException {
        InputStream in = (InputStream) environment.getObject(Rack.RACK_INPUT);
        long length = getRequestContentlength(environment);
        Charset charset = getRequestCharacterSet(environment);

        if (null != charset && length > 0) {
            return readAsString(in, length, charset);
        }

        if (null != charset && length <= 0) {
            return readAsString(in, charset);
        }

        if (null == charset && length > 0) {
            return readAsString(in, length);
        }

        return readAsString(in);
    }

    public static byte[] readRequestBodyAsBytes(Context<String> environment) throws IOException {
        InputStream in = (InputStream) environment.getObject(Rack.RACK_INPUT);
        long length = getRequestContentlength(environment);

        if (length > 0) {
            return readAsBytes(in, length);
        }

        return readAsBytes(in);
    }

    /**
     * read the request Content-Length header as a long
     *
     * @return the converted value or 0 if not supplied
     */
    public static long getRequestContentlength(Context<String> environment) {
        long length = 0;
        String contentLength = (String) environment.get(Rack.HTTP_ + "Content-Length");
        if (null != contentLength) length = Long.parseLong(contentLength);

        return length;
    }


    /**
     * read the request Content-Type charset, if supplied and valid, as a Charset
     *
     * @return the converted value or null if invald or not supplied
     */
    public static Charset getRequestCharacterSet(Context<String> environment) {
        Charset charset = null;
        String contentType = (String) environment.get(Rack.HTTP_ + "Content-Type");
        if (null != contentType) {
            int semicolon = contentType.indexOf(';');
            if (semicolon >= 0) {
                String charsetName = contentType.substring(semicolon + 1).trim();
                try {
                    charset = Charset.forName(charsetName);
                } catch (IllegalCharsetNameException icne) {
                    // ignore illegal or unknown names
                } catch (UnsupportedCharsetException uce) {
                    // ignore illegal or unknown names
                }
            }
        }

        return charset;
    }
}