package com.mbasic.filter;

import com.mbasic.dal.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/addItem"})
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        if (loggedIn) {
            User user = (User) session.getAttribute("user");
            boolean isAdmin = user.getRole().equals("ADMIN");
            if (isAdmin) {
                chain.doFilter(req, resp);
            } else {
                response.sendError(401);
            }
        } else {
            response.sendError(403);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
