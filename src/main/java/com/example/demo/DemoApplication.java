package com.example.demo;

import com.example.demo.rest.CustomAspectProcessor;
import com.example.demo.rest.RestContainer;
import com.example.demo.rest.TestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CustomAspectProcessor.applicationContext = SpringApplication.run(DemoApplication.class, args);
      /*  CustomAspectProcessor.process(TestController.class);

        ResponseEntity responseEntity = RestContainer.invokeInternal("/user/getByUsername","rubenmanukyan1993@gmail.com");

        ResponseEntity responseEntity2 = RestContainer.invokeInternal("/user/getById",3);
        System.out.println(responseEntity2.getBody());
        System.out.println(responseEntity.getBody());*/
    }



    @Value("${spring.token.datasource.url}")
    private String url;

    @Value("${spring.token.datasource.username}")
    private String username;

    @Value("${spring.token.datasource.password}")
    private String password;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }


    @Bean
    public TokenStore tokenStore() {
        DataSource dataSource = DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .build();
        return new JdbcTokenStore(dataSource);
    }
}
