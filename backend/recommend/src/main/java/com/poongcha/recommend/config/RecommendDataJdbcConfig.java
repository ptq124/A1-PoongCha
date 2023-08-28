package com.poongcha.recommend.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.core.convert.BasicJdbcConverter;
import org.springframework.data.jdbc.core.convert.BatchJdbcOperations;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.convert.DefaultJdbcTypeFactory;
import org.springframework.data.jdbc.core.convert.InsertStrategyFactory;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.RelationResolver;
import org.springframework.data.jdbc.core.convert.SqlGeneratorSource;
import org.springframework.data.jdbc.core.convert.SqlParametersFactory;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.DialectResolver;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@EnableJdbcRepositories(
        jdbcOperationsRef = "recommendNamedParameterJdbcOperations",
        transactionManagerRef = "recommendTransactionManager",
        dataAccessStrategyRef = "recommendDataAccessStrategy",
        basePackages = "com.poongcha.recommend"
)
@Configuration
class RecommendDataJdbcConfig {
    @Bean
    @Qualifier("recommend")
    JdbcCustomConversions recommendJdbcCustomConversions() {
        return new JdbcCustomConversions();
    }

    @Bean
    @Primary
    @Qualifier("recommend")
    JdbcMappingContext recommendJdbcMappingContext(
            Optional<NamingStrategy> namingStrategyOption,
            @Qualifier("recommend") JdbcCustomConversions recommendJdbcCustomConversions
    ) {
        JdbcMappingContext mappingContext = new JdbcMappingContext(
                namingStrategyOption.orElse(NamingStrategy.INSTANCE)
        );
        mappingContext.setSimpleTypeHolder(recommendJdbcCustomConversions.getSimpleTypeHolder());
        return mappingContext;
    }

    @Bean
    @Primary
    @Qualifier("recommend")
    DataAccessStrategy recommendDataAccessStrategy(
            @Qualifier("recommend") NamedParameterJdbcOperations operations,
            @Qualifier("recommend") JdbcConverter jdbcConverter,
            @Qualifier("recommend") JdbcMappingContext context,
            @Qualifier("recommend") Dialect dialect
    ) {
        return new DefaultDataAccessStrategy(
                new SqlGeneratorSource(
                        context,
                        jdbcConverter,
                        DialectResolver.getDialect(operations.getJdbcOperations())
                ),
                context,
                jdbcConverter,
                operations,
                new SqlParametersFactory(context, jdbcConverter, dialect),
                new InsertStrategyFactory(
                        operations,
                        new BatchJdbcOperations(operations.getJdbcOperations()),
                        dialect
                )
        );
    }

    @Bean
    @Primary
    @Qualifier("recommend")
    JdbcConverter recommendJdbcConverter(
            @Qualifier("recommend") JdbcMappingContext mappingContext,
            @Qualifier("recommend") NamedParameterJdbcOperations operations,
            @Lazy @Qualifier("recommend") RelationResolver relationResolver,
            @Qualifier("recommend") JdbcCustomConversions conversions
    ) {
        DefaultJdbcTypeFactory jdbcTypeFactory = new DefaultJdbcTypeFactory(operations.getJdbcOperations());
        Dialect dialect = DialectResolver.getDialect(operations.getJdbcOperations());
        return new BasicJdbcConverter(
                mappingContext,
                relationResolver,
                conversions,
                jdbcTypeFactory,
                dialect.getIdentifierProcessing()
        );
    }
}
