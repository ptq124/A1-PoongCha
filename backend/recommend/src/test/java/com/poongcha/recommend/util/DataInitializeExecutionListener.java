package com.poongcha.recommend.util;

import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswer;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateRecommendation;
import com.poongcha.recommend.domain.lifestylepersona.LifestyleInterview;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaAdditionalQuestionOption;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaLifestylePersonaSituationTag;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import com.poongcha.recommend.domain.recommendationfeedback.RecommendationFeedback;
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
        reset(operation, AdditionalQuestion.class.getAnnotation(Table.class).name());
        reset(operation, AdditionalQuestionOption.class.getAnnotation(Table.class).name());
        reset(operation, AdditionalQuestionAnswerGroup.class.getAnnotation(Table.class).name());
        reset(operation, AdditionalQuestionAnswer.class.getAnnotation(Table.class).name());
        reset(operation, LifestylePersonaSituationTag.class.getAnnotation(Table.class).name());
        reset(operation, LifestylePersona.class.getAnnotation(Table.class).name());
        reset(operation, LifestyleInterview.class.getAnnotation(Table.class).name());
        reset(operation, LifestylePersonaAdditionalQuestionOption.class.getAnnotation(Table.class).name());
        reset(operation, LifestylePersonaLifestylePersonaSituationTag.class.getAnnotation(Table.class).name());
        reset(operation, RecommendationFeedback.class.getAnnotation(Table.class).name());
        reset(operation, CarEstimateRecommendation.class.getAnnotation(Table.class).name());
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
