package com.qc.bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(features = "src/test/resources", glue = "com.qc.bdd.steps", tags = "@login")
@RunWith(Cucumber.class)
public class Runner {

}
