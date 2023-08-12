package com.poongcha.recommend.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
class RecommendTransactionConfig {
    @Bean
    @Qualifier("recommend")
    TransactionManager recommendTransactionManager(@Qualifier("recommend") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
