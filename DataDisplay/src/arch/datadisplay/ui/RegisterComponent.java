package arch.datadisplay.ui;

import java.util.Properties;

import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

public class RegisterComponent {
    protected void setHttpService(HttpService httpService) {
        HttpContext context = httpService.createDefaultHttpContext();
        try {
            httpService.registerServlet("/display", new DisplayServlet(), new Properties(), context);
            httpService.registerResources("/", "/html", context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void unsetHttpService(HttpService httpService) {
        httpService.unregister("/");
        httpService.unregister("/display");
    }
}
