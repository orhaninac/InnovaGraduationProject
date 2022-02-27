package com.orhaninac.innovagraduationproject;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class InnovaGraduationProjectApplicationTests {

    @Test
    void contextLoads() {
    }
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
