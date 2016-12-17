package com.myself.server.resources;

import com.myself.server.cache.LightCacheMapImpl;
import com.myself.server.conncector.handler.TripleColourLightHandler;
import com.myself.server.vo.RestResponse;
import com.myself.server.vo.SampleVo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex.Chen on 2016/12/17.
 */

@Component
@Path("/v1/triColourLight")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "三色灯相关操作接口", produces = "application/json")
public class TriColourLightResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TriColourLightResource.class);

    @Autowired
    private MessageSource messageSource;


    @GET
    @Path("/allLightInfo")
    @ApiOperation(value = "获取所有三色灯状态",
            response = SampleVo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public Response getAllLightInfo(){
        LOGGER.info("call getAllLightInfo");
        RestResponse restResponse = new RestResponse();
        restResponse.setStatusCode("0");
        Map allLightInfo = LightCacheMapImpl.getCurrentAllStatus();
        restResponse.setObject(allLightInfo);
        return Response.status(Response.Status.OK).entity(restResponse).build();
    }


    @GET
    @Path("/lightInfo/{id}")
    @ApiOperation(value = "获取单个三色灯详细数据",
            response = SampleVo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public Response getLightInfo(@ApiParam @PathParam("id") String id){
        LOGGER.info("call getLightInfo");
        RestResponse restResponse = new RestResponse();
        if(StringUtils.isEmpty(id)){
            restResponse.setStatusCode("1");
            restResponse.setMessage(messageSource.getMessage("rest.request.empty",null,
                    LocaleContextHolder.getLocale()));
            return Response.status(Response.Status.BAD_REQUEST).entity(restResponse).build();
        }
        restResponse.setStatusCode("0");
        int status = LightCacheMapImpl.getLightStatus(Integer.valueOf(id));
        Map result = new HashMap<>();
        result.put("status",status);
        restResponse.setObject(result);
        return Response.status(Response.Status.OK).entity(restResponse).build();
    }

    @PUT
    @Path("/lightInfo/{id}/{status}")
    @ApiOperation(value = "更新三色灯状态",
            response = SampleVo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public Response updateLightInfo(@ApiParam @PathParam("id") String id,
                                 @ApiParam @PathParam("status") String status){
        LOGGER.info("call updateLightInfo");
        RestResponse restResponse = new RestResponse();
        if(StringUtils.isEmpty(id) || StringUtils.isEmpty(status)){
            restResponse.setStatusCode("1");
            restResponse.setMessage(messageSource.getMessage("rest.request.empty",null,
                    LocaleContextHolder.getLocale()));
            return Response.status(Response.Status.BAD_REQUEST).entity(restResponse).build();
        }
        TripleColourLightHandler.lightControlCall(Integer.valueOf(id));
        restResponse.setStatusCode("0");
        restResponse.setMessage(messageSource.getMessage("light.update.successful",null,
                LocaleContextHolder.getLocale()));
        return Response.status(Response.Status.OK).entity(restResponse).build();
    }
}
