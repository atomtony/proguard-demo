package com.proguard.demo;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.proguard")
@EnableScheduling
@Log4j2
public class DemoStartup {


    public static class CustomGenerator implements BeanNameGenerator {

        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            return definition.getBeanClassName();
        }
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(DemoStartup.class)
                .beanNameGenerator(new CustomGenerator())
                .run(args);
    }

}
