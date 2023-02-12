package com.ivanov.laboratory.config;

import com.ivanov.laboratory.utils.Analyzators.Analyzator;
import com.ivanov.laboratory.utils.ProcessingAnalyze;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LabConfig {

    @Bean
    public ProcessingAnalyze processingAnalyze() {
        return new ProcessingAnalyze();
    }

    @Bean
    public Analyzator analizator1() {
        return new Analyzator();
    }

    @Bean
    public Analyzator analyzator2() {
        return new Analyzator();
    }
}
