package cn.binarywang.java.camel.runner;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileMoveCamel {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("file:d:/tmp/inbox/?delay=30000").to("file:d:/tmp/outbox");
            }
        });

        context.start();

        boolean loop = true;
        while (loop) {
            Thread.sleep(25000);
        }

        context.stop();
    }
}
