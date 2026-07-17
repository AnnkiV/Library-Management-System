package com.manage.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Configuration
public class SecurityConfig {
	
	@Bean
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }
	
    public static void main(String[]args){
    	
    }
}
