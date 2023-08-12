package com.poongcha.car.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.MySqlDialect;

@Configuration
class CarDataSourceConfig {
    @Bean
    @Primary
    @Qualifier("car")
    Dialect carJdbcDialect() {
        return MySqlDialect.INSTANCE;
    }

    @Bean
    @Qualifier("car")
    @ConfigurationProperties("spring.datasource.car")
    DataSourceProperties carDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("car")
    DataSource carDatasource() {
        return carDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
