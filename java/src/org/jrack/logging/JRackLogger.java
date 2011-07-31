package org.jrack.logging;

/**
 * Abstract logging support
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 11-07-30 7:37 PM)
 */
public interface JRackLogger {
    void log(String message);

    void log(String message, Throwable ex);
}
