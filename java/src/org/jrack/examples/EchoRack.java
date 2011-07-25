package org.jrack.examples;

import org.jrack.JRack;
import org.jrack.RackEnvironment;
import org.jrack.RackResponse;
import org.jrack.RackResponseUtils;
import org.jrack.utils.Copy;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 11-07-24 6:46 PM)
 */
public class EchoRack implements JRack {
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html";
    public static final String CONTENT_TYPE = "Content-Type";

    @Override
    public RackResponse call(Map<String, Object> environment) throws Exception {
        return new RackResponse(RackResponseUtils.ReturnCode.OK,
                Collections.singletonMap(CONTENT_TYPE, CONTENT_TYPE_TEXT_HTML),
                Copy.copyToString(((HttpServletRequest) environment.get(
                        RackEnvironment.REQUEST)).getReader()));
    }
}
