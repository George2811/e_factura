package com.example.e_factura;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EFacturaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EFacturaApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){ return new ModelMapper(); }

}
