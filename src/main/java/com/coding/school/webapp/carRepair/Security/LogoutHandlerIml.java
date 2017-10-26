package com.coding.school.webapp.carRepair.Security;

import com.coding.school.webapp.carRepair.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutHandlerIml implements LogoutSuccessHandler {

    @Autowired
    private OwnerService ownerService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        ownerService.logout(username, password);
        httpServletResponse.sendRedirect("/login");
    }
}
