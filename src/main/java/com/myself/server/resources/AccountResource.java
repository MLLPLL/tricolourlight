package com.myself.server.resources;

import com.myself.server.entity.Account;
import com.myself.server.service.AccountService;
import com.myself.server.vo.*;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Component
@Path("/v1/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "用户相关操作接口", produces = "application/json")
public class AccountResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private AccountService accountService;


    @GET
    @Path("/login/{username}/{password}")
    @ApiOperation(value = "用户登入接口，登入成功获取Token来请求别的接口",
            response = SampleVo.class)
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public Response login(@ApiParam @PathParam("username") String username,
                          @ApiParam @PathParam("password") String password) {
        RestResponse restResponse = new RestResponse();
        Account account = accountService.login(username,password);
        if(account != null){
            AccountVo accountVo = new AccountVo();
            BeanUtils.copyProperties(account,accountVo,new String[]{"password"});
            restResponse.setStatusCode("0");
            restResponse.setObject(accountVo);
        }else{
            restResponse.setStatusCode("1");
            restResponse.setMessage("用户名或者密码错误");
        }

        return Response.status(Status.OK).entity(restResponse).build();
    }


    @POST
    @Path("/add")
    @ApiOperation(value = "添加用户",
            response = SampleVo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public Response add(AccountVo accountVo) {
        RestResponse restResponse = new RestResponse();
        Account account = new Account();
        BeanUtils.copyProperties(accountVo,account);
        accountService.saveAccount(account);
        restResponse.setStatusCode("0");
        restResponse.setMessage("保存成功");

        return Response.status(Status.OK).entity(restResponse).build();
    }

    /**
     * 测试方法，查询数据库，返回查询对象
     * @return response 返回的请求结果
     */
//    @GET
//    @Path("/sample")
//    @ApiOperation(value = "JPA 简单的整合测试方法",response = Hello.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Resource found"),
//            @ApiResponse(code = 404, message = "Resource not found")})
//    public Response sample() {
//        LOGGER.info("Start sample request");
//        Sample sample = sampleService.getSampleById(1);
//        return Response.status(Status.OK).entity(sample).build();
//    }
//
//    private Response constructHelloResponse(String name, String via) {
//        //for testing how we handle 404
//        if ("404".equals(name)) {
//            return Response.status(Status.NOT_FOUND).build();
//        }
//        Hello result = new Hello();
//        result.setMsg(String.format("Hello %s - %s", name, via));
//        return Response.status(Status.OK).entity(result).build();
//    }
}