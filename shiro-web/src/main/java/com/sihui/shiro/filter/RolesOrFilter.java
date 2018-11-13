package com.sihui.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author sihui.sha
 * @date 2018/11/13
 */
public class RolesOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[]) o;
        if (roles == null || roles.length == 0){
            return true;
        }
        for (String role : roles){
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
