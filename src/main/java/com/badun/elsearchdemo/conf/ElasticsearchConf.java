package com.badun.elsearchdemo.conf;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetSocketAddress;

import javax.annotation.Resource;

/**
 * Created by Artsiom Badun.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com/badun/elsearchdemo/data/repo")
public class ElasticsearchConf {

    @Resource
    private Environment environment;
    @Bean
    public Client client() {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", environment.getProperty("elsearch.cluster.name")).build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        TransportAddress address = new InetSocketTransportAddress(
                new InetSocketAddress(
                        environment.getProperty("elsearch.host"), Integer.valueOf(environment.getProperty("elsearch.port"))
                )
        );
        client.addTransportAddress(address);
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
