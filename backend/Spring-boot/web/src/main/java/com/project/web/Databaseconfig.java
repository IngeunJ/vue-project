package com.project.web;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Databaseconfig
 */
@Configuration //빈을 생성
public class Databaseconfig {
    
      @Bean
    public ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new WebServlet());
        registration.addUrlMappings("/console/*");

        return registration;
    }

    
}