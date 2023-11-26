package com.kenInternational.project_Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Project_Configuration {
    @Bean(name = "GetMapper")
    public ModelMapper GetMapper(){
        return new ModelMapper();
    }
}
