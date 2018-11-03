package com.ypxx.manage.common.filter;

import com.ypxx.manage.common.utils.SpringUtil;
import com.ypxx.manage.common.utils.UserUtils;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.permission.service.IPermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

/**
 * Created by xuwei on 2018/10/12.
 */
public class URLPathMatchingFilter extends PathMatchingFilter {

    @Autowired
    private IPermissionService permissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (permissionService==null){
            permissionService= SpringUtil.getBean(IPermissionService.class);
        }
        String requestURL = getPathWithinApplication(request);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) return true;
        String username = UserUtils.getUser().getUsername();
        List<PermissionEntity> permissions = permissionService.findPermissionListByUsername(username);

        boolean hasPermission = false;
        for (PermissionEntity url : permissions) {
            if (url.getUrl().equals(requestURL)){
                hasPermission = true;
                break;
            }
        }
        if (hasPermission){
            return true;
        }else {
            UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径" + requestURL + "的权限");
            subject.getSession().setAttribute("ex",ex);
            WebUtils.issueRedirect(request, response, "/unauthorized");
            return false;

        }
    }
}
