package com.poongcha.car.util;

import com.poongcha.car.domain.carcolor.CarColor;
import com.poongcha.car.domain.carcolor.IncompatibleCarColor;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupCarOption;
import com.poongcha.car.domain.caroptiongroup.IncompatibleCarOptionGroup;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.trim.Trim;
import com.poongcha.car.domain.trim.TrimCarColor;
import java.sql.PreparedStatement;
import org.springframework.context.ApplicationContext;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class DataInitializeExecutionListener extends AbstractTestExecutionListener {
    @Override
    public void beforeTestMethod(final TestContext testContext) {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        NamedParameterJdbcOperations operation = applicationContext.getBean(NamedParameterJdbcOperations.class);
        reset(operation, CarType.class.getAnnotation(Table.class).name());
        reset(operation, Trim.class.getAnnotation(Table.class).name());
        reset(operation, CarColor.class.getAnnotation(Table.class).name());
        reset(operation, TrimCarColor.class.getAnnotation(Table.class).name());
        reset(operation, IncompatibleCarColor.class.getAnnotation(Table.class).name());
        reset(operation, CarComponentGroup.class.getAnnotation(Table.class).name());
        reset(operation, CarComponent.class.getAnnotation(Table.class).name());
        reset(operation, CarOptionGroup.class.getAnnotation(Table.class).name());
        reset(operation, CarOption.class.getAnnotation(Table.class).name());
        reset(operation, CarOptionGroupCarOption.class.getAnnotation(Table.class).name());
        reset(operation, IncompatibleCarOptionGroup.class.getAnnotation(Table.class).name());
    }

    private static void reset(
            final NamedParameterJdbcOperations operation,
            final String tableName
    ) {
        operation.execute("set foreign_key_checks = 0;", PreparedStatement::execute);
        operation.execute(String.format("truncate table %s;", tableName), PreparedStatement::execute);
        operation.execute("set foreign_key_checks = 1;", PreparedStatement::execute);
    }
}
