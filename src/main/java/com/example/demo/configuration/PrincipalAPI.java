package com.example.demo.configuration;

import com.example.demo.configuration.routes.SimpleRequest;
import com.example.demo.configuration.routes.UserRoutes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import org.apache.camel.spi.PropertiesComponent;

@Component
@ComponentScan("com.example.demo.configuration.routes")
public class PrincipalAPI {

    @Value("${server.port2}")
    String serverPort;

    @Value("${baeldung.api.path}")
    String contextPath;

    @Autowired
    CamelContext camelContext;


   @Component
   class RestApi extends RouteBuilder {


       @Override
       public void configure() throws Exception{ 

        //   CamelContext context = new DefaultCamelContext();

           restConfiguration().contextPath(contextPath) //
               .port(serverPort)
               .enableCORS(true)
               .apiContextPath("/api-doc")
               .apiProperty("api.title", "Test REST API")
               .apiProperty("api.version", "v1")
               .apiProperty("cors", "true") // cross-site
               
               .apiContextRouteId("doc-api")
               .component("servlet")
    //           .bindingMode(RestBindingMode.json)
               .dataFormatProperty("prettyPrint", "true");

               PropertiesComponent pc = camelContext.getPropertiesComponent();
               pc.setLocation("classpath:application.properties");   


           rest("/api/").description("Books REST service")
           .get("/books")
           .to("direct:askGoogle");

           from("direct:askGoogle").to("http:www.google.com?bridgeEndpoint=true");

           camelContext.addRoutes(new RouteBuilder(){
                @Override
                public void configure() throws Exception{ 
                    from("direct:askGoogle2").to("http:www.google.com?bridgeEndpoint=true");
                }
           });

           camelContext.addRoutes(new SimpleRequest());
           camelContext.addRoutes(new UserRoutes());


       }
  }  
}
