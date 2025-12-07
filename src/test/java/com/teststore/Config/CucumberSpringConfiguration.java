package com.teststore.Config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = CitrusConfig.class)
public class CucumberSpringConfiguration {
}
