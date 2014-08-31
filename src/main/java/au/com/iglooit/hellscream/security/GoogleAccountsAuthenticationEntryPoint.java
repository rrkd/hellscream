package au.com.iglooit.hellscream.security;

import au.com.iglooit.hellscream.properties.WebProperties;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoogleAccountsAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {
        UserService userService = UserServiceFactory.getUserService();
        WebProperties webProperties = WebProperties.getInstance();
        String loginUrl = webProperties.get("login.url");
        response.sendRedirect(userService.createLoginURL(request.getRequestURI()));
//        response.sendRedirect("http://spring-forest-538.appspot.com/_ah/login?continue=home");
    }
}
