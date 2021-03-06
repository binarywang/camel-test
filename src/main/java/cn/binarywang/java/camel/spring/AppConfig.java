package cn.binarywang.java.camel.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.binarywang.java.camel.processor.ExchangeViewer;

@Configuration
public class AppConfig {
    @Bean
    public CamelContext camelContext() throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        final Processor processor = processor();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("file:d:/tmp/9/?delay=30000").process(processor)
                    .to("file:d:/tmp/1");
            }
        });

        return camelContext;
    }

    @Bean
    public Processor processor() {
        return new ExchangeViewer();
    }
}
