package com.spring.esAPI;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.util.Objects;


@Configuration
public class ElasticConfiguration {

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        String userName = Objects.isNull(System.getenv("ELS_USER_NAME")) ? Constants.ELS_USERNAME : System.getenv("ELS_USER_NAME");
        String password = Objects.isNull(System.getenv("ELS_PASSWORD")) ? Constants.ELS_PASSWORD : System.getenv("ELS_USER_NAME");
        String elsURL = Objects.isNull(System.getenv("ELS_URL")) ? Constants.ELS_URL : System.getenv("ELS_USER_NAME");

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elsURL)
                .withBasicAuth(userName, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
