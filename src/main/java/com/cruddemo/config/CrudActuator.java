package com.cruddemo.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class CrudActuator implements HealthIndicator {
    @Override
    public Health health() {
        return checkIntenetConnectivity() ? Health.up().withDetail("Success", "Internet Connection Active").build()
                : Health.down().withDetail("Error", "No Internet Connectivity").build();
    }

    public boolean checkIntenetConnectivity(){
        boolean internetConnectivityFlag = false;
        try {
            URL url = new URL("https://www.google.com");
            url.openConnection().connect();
            internetConnectivityFlag = true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return internetConnectivityFlag;
    }
}
