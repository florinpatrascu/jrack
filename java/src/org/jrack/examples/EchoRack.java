package org.jrack.examples;

import org.jrack.*;
import org.jrack.utils.StreamHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 11-07-24 6:46 PM)
 */
public class EchoRack extends JRack {
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=utf-8";

    @Override
    public RackResponse call(Context<String> input) throws Exception {
        HttpServletRequest request = (HttpServletRequest) input.getObject(Rack.REQUEST);
        return new RackResponse(RackResponseUtils.ReturnCode.OK)
                .withContentType(CONTENT_TYPE_TEXT_HTML)
                .withBody(StreamHelper.readAsBytes(request.getInputStream()));
    }
}
