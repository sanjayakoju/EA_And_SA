package com.example.programmingtest3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@EnableJms
public class ProgrammingTest3Application {

    public static void main(String[] args) {
        SpringApplication.run(ProgrammingTest3Application.class, args);
    }

    @Bean
    public AcceptHeaderLocaleResolver localResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

}
