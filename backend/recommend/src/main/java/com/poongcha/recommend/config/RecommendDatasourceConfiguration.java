package com.poongcha.recommend.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RecommendDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.recommend")
    public DataSourceProperties recommendDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource recommendDatasource() {
        return recommendDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate recommendJdbcTemplate(@Qualifier("recommendDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
