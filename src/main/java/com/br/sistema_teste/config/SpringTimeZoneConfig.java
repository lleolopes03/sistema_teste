package com.br.sistema_teste.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfig {
    @PostConstruct
    public void timezoneceConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));

    }
}
