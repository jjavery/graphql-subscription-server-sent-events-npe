package com.example.demo;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        var factory = new TomcatServletWebServerFactory();

        //  factory.addConnectorCustomizers(connector -> connector.setAsyncTimeout((long)60 * 60 * 1000));

        return factory;
    }
}
