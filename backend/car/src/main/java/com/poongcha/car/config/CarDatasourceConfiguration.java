package com.poongcha.car.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CarDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.car")
    public DataSourceProperties carDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource carDatasource() {
        return carDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate carJdbcTemplate(@Qualifier("carDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
