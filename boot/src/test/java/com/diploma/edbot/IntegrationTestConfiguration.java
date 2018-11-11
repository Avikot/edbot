package com.diploma.edbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@Configuration
@ComponentScan(basePackages = {"com.diploma.edbot"})
@EnableAutoConfiguration(exclude = {FlywayAutoConfiguration.class})
@EnableCaching
public class IntegrationTestConfiguration {

    @Autowired
    private WebApplicationContext wac;

//    @Autowired
//    private SessionRepositoryFilter<? extends Session> sessionRepositoryFilter;
//
//    @Bean
//    CacheManager cacheManager() {
//        return new EhCacheCacheManager();
//    }

    @Bean
    MockMvc mockMvc(){
        return MockMvcBuilders
                .webAppContextSetup(wac)
//                .addFilter(sessionRepositoryFilter)
                .apply(springSecurity())
                .build();
    }

}
