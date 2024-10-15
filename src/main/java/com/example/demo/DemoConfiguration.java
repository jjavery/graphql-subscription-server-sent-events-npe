package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.webmvc.GraphQlSseHandler;

@Configuration
public class DemoConfiguration {

    /*
     * Comment out this bean definition to use the default GraphQlSseHandler
     * which will reproduce the issue fixed by this commit:
     *
     * https://github.com/spring-projects/spring-graphql/commit/d3cd569e940479db7a2aab0a9b12aa81f1206ced
     */
    @Bean
    GraphQlSseHandler graphQlSseHandler(WebGraphQlHandler webGraphQlHandler) {
        return new GraphQlSseHandler133(webGraphQlHandler);
    }

}
