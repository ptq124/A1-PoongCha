package com.poongcha.recommend.config;

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
class RecommendDataSourceConfig {
    @Bean
    @Primary
    @Qualifier("recommend")
    Dialect recommendJdbcDialect() {
        return MySqlDialect.INSTANCE;
    }

    @Bean
    @Qualifier("recommend")
    @ConfigurationProperties("spring.datasource.recommend")
    DataSourceProperties recommendDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("recommend")
    DataSource recommendDatasource() {
        return recommendDatasourceProperties().initializeDataSourceBuilder().build();
    }
}
