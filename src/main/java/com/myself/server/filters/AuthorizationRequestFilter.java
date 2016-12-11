package com.myself.server.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.myself.server.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Alex.Chen
 *         Header头Token的拦截例子，详细逻辑需要重写
 */

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationRequestFilter.class);

    @Autowired
    private AccountService accountService;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if("OPTIONS".equals(containerRequestContext.getMethod())){
            return;
        }
        ContainerRequest request = (ContainerRequest) containerRequestContext;
//        LOGGER.info("验证权限,使用" + request.getHeaderString("User-Agent") + ",以" + request.getMethod() + "的方式请求资源:" + request.getPath(true));
        String token = request.getHeaderString("Authorization_Token");
        if ("swagger.json".equals(request.getPath(true)) ||
                request.getPath(true).indexOf("v1/account/login")>-1) {
            return;
        }
        if (!accountService.validateToken(token)) {
            Map<String,String> result = new HashMap<>();
            result.put("message","没有权限操作，请先登入");
            containerRequestContext.abortWith(Response
                    .status(Response.Status.FORBIDDEN)
                    .entity(result)
                    .build());
        }
    }
}
