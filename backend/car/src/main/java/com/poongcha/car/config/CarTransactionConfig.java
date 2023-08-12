package com.poongcha.car.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
class CarTransactionConfig {
    @Bean
    @Qualifier("car")
    TransactionManager carTransactionManager(@Qualifier("car") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
