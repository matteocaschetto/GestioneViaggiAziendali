package com.epicode.GestioneViaggiAziendali.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ServerConfig {

    @Bean
    public Cloudinary configurazioneCloud() {
        Map<String, String> configurazione = new HashMap<String, String>();
        configurazione.put("cloud_name", "dlo86p6cf");
        configurazione.put("api_key", "834275569256239");
        configurazione.put("api_secret", "CpUU_h8uK1Uwlb-vDb0fEfvx7lQ");
        return new Cloudinary(configurazione);
    }
}
