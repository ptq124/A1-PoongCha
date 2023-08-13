package com.poongcha.car.util;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.snippet.Snippet;

@ExtendWith({RestDocumentationExtension.class})
public class DocumentationTest extends AcceptanceTest {
    public static final String DEFAULT_RESTDOCS_PATH = "{class_name}/{method_name}/";

    private static RequestSpecification spec;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
        this.spec = new RequestSpecBuilder().setPort(port)
                .addFilter(
                        documentationConfiguration(restDocumentationContextProvider)
                                .operationPreprocessors()
                                .withRequestDefaults(prettyPrint())
                                .withResponseDefaults(prettyPrint())
                ).build();
    }

    public static RequestSpecification given() {
        return RestAssured.given(getSpec())
                .accept("application/json");
    }

    private static RequestSpecification getSpec() {
        return spec;
    }

    public static Snippet customRequestFields(FieldDescriptor... fieldDescriptors) {
        return requestFields(fieldDescriptors);
    }
}
