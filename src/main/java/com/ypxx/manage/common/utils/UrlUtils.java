package com.ypxx.manage.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * Created by xuwei on 2018/10/8.
 */
public class UrlUtils {

    /**
     * 获取所有控制层访问路径
     */
    public static  Set<String> getAllUrl(){
        RequestMappingHandlerMapping mapping = SpringUtil.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        Set<String> urlList = new LinkedHashSet<>();
        for (RequestMappingInfo info : map.keySet()){
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            urlList.addAll(patterns);
        }
        return urlList;
    }
}
