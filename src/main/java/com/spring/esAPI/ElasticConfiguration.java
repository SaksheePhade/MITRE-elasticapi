package com.spring.esAPI;

import com.spring.esAPI.dao.TechniqueDao;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.util.Objects;


@Configuration
public class ElasticConfiguration {
    Logger logger = LoggerFactory.getLogger(ElasticConfiguration.class);

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        String userName = Objects.isNull(System.getenv("ELS_USER_NAME")) ? Constants.ELS_USERNAME : System.getenv("ELS_USER_NAME");
        String password = Objects.isNull(System.getenv("ELS_PASSWORD")) ? Constants.ELS_PASSWORD : System.getenv("ELS_USER_NAME");
        String elsURL = Objects.isNull(System.getenv("ELS_URL")) ? Constants.ELS_URL : System.getenv("ELS_USER_NAME");
        logger.info("Connecting to els " + elsURL + " with username: " + userName);
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elsURL)
                .withBasicAuth(userName, password)
                .build();
        logger.info("Connected to els successfully");
        return RestClients.create(clientConfiguration).rest();
    }
}
