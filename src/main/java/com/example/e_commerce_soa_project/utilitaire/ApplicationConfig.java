package com.example.e_commerce_soa_project.utilitaire;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.wadl.disableWadl", true);
        return properties;
    }
}
