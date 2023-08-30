package com.poongcha.car.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
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
        jdbcOperationsRef = "carNamedParameterJdbcOperations",
        transactionManagerRef = "carTransactionManager",
        dataAccessStrategyRef = "carDataAccessStrategy",
        basePackages = "com.poongcha.car"
)
@Configuration
class CarDataJdbcConfig {
    @Bean
    @Qualifier("car")
    JdbcCustomConversions carJdbcCustomConversions() {
        return new JdbcCustomConversions();
    }

    @Bean
    @Qualifier("car")
    JdbcMappingContext carJdbcMappingContext(
            Optional<NamingStrategy> namingStrategyOption,
            @Qualifier("car") JdbcCustomConversions carJdbcCustomConversions
    ) {
        JdbcMappingContext mappingContext = new JdbcMappingContext(
                namingStrategyOption.orElse(NamingStrategy.INSTANCE)
        );
        mappingContext.setSimpleTypeHolder(carJdbcCustomConversions.getSimpleTypeHolder());
        return mappingContext;
    }

    @Bean
    @Qualifier("car")
    JdbcConverter carJdbcConverter(
            @Qualifier("car") JdbcMappingContext mappingContext,
            @Qualifier("car") NamedParameterJdbcOperations operations,
            @Lazy @Qualifier("car") RelationResolver relationResolver,
            @Qualifier("car") JdbcCustomConversions conversions
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

    @Bean
    @Qualifier("car")
    DataAccessStrategy carDataAccessStrategy(
            @Qualifier("car") NamedParameterJdbcOperations operations,
            @Qualifier("car") JdbcConverter jdbcConverter,
            @Qualifier("car") JdbcMappingContext context,
            @Qualifier("car") Dialect dialect
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
                        dialect)
        );
    }
}
