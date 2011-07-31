package org.jrack.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The default logging support; Slf4j
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 11-07-30 7:38 PM)
 */
public class Slf4jLogger implements JRackLogger {
    private Logger logger;

    public Slf4jLogger(String loggerName) {
        setLoggerName(loggerName);
    }

    public void setLoggerName(String loggerName) {
        logger = LoggerFactory.getLogger(loggerName);
    }

    public void log(String message) {
        logger.info(message);
    }

    public void log(String message, Throwable ex) {
        logger.error(message, ex);
    }
}
