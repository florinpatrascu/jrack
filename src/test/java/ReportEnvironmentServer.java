import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ReportEnvironmentServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletOutputStream out = resp.getOutputStream();
        Enumeration e = req.getHeaderNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            out.print(String.format("%s = %s <br>", key, req.getHeader(key)));
        }

        out.flush();
    }
}
