package com.myself.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.myself.server.entity"})
@EnableJpaRepositories(basePackages = {"com.myself.server.repository"})
@EnableTransactionManagement
public class RepositoryConfig {

}
