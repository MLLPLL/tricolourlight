package com.myself.server.config;

import javax.annotation.PostConstruct;

import com.myself.server.utils.PropertiesUtil;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.scanning.PackageNamesScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;


@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${server.context-path}")
    private String rootPath;

    public JerseyConfig() {
        String[] packages = new String[]{"com.myself.server.resources","com.myself.server.filters"};
        PackageNamesScanner packageNamesScanner = new PackageNamesScanner(packages,false);
        this.registerFinder(packageNamesScanner);
    }
    
    @PostConstruct
    public void init() {
        this.configureSwagger();
    }

    private void configureSwagger() {

        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("server rest api\n请求接口时请先请求登陆接口获取token");
        config.setVersion("v1");
        config.setContact("Alex.Chen");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath(rootPath+"/api");
        config.setResourcePackage("com.myself.server.resources");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}
