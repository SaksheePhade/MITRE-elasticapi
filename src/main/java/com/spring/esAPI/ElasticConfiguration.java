package com.spring.esAPI;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;



@Configuration
public class ElasticConfiguration {
	
	 	@Bean
	    public RestHighLevelClient elasticsearchClient() {

	        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
	                .connectedTo(Constants.ELASTIC_URL)
	                .build();

	        return RestClients.create(clientConfiguration).rest();
	    }
}
