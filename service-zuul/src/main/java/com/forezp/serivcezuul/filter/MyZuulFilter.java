package com.forezp.serivcezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * filterType 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
     * 1.pre 路由之前 2.outing 路由之时 3.post 路由之后 4.error 发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    // filterOrder：过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //shouldFilter：这里可以写逻辑判断，是否要过滤，如何过滤，返回true就是过滤。这里就是永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //run：过滤器的具体逻辑。
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}