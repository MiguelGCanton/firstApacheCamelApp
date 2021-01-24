package com.example.demo.configuration.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.apache.camel.Processor;


public class SimpleRequest extends RouteBuilder{

    @Value("${server.port}")
    String serverPort;

    @Value("${baeldung.api.path}")
    String contextPath;

    @Autowired
    CamelContext apacheCamel;

    @Value("${http.socialMedia.url}")
    String requestUrl;


    @Override
    public void configure() { 
        String url = "https://" +  requestUrl +  "?bridgeEndpoint=true" ;

        rest("/api/")
      //  
        .get("/cats/facts")
        
        .to("direct:getCatInformation");


        from("direct:getCatInformation")
        .transform().simple("Hi ${body} Hi ${properties:http.socialMedia.url}. .")    
        
        .process(new Processor(){

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getMessage().getBody());

                        String helloMessage = exchange.getMessage().getBody(String.class) ;

                        System.out.println(helloMessage);
                        exchange.getMessage().setBody(helloMessage + "ahsdkjashd");
                    }
            
        })
     //  .to("https://cat-fact.herokuapp.com/facts?bridgeEndpoint=true")
      ;
    }
    
}