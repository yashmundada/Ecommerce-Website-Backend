package com.ecommerce.productservicenovermber2024.ApplicationConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ApplicationConfig {      //this is a configuration class.and annotated with @Configuration.
    @Bean                                    //denotes that this method is beanProducer  //beans are objects.
    public RestTemplate restTemplate() {      //restTemplate third party -call use-interservice communication between 2 services.
        return new RestTemplate();
    }
}
