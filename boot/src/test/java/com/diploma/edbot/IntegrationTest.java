package com.diploma.edbot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@SpringBootTest(classes = IntegrationTestConfiguration.class)
@Import(IntegrationTestDataSourceConfiguration.class)
@ActiveProfiles("integrationTest")
public @interface IntegrationTest {

}