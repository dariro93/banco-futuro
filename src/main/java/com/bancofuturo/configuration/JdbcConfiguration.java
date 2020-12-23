package com.bancofuturo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:22 PM
 *
 * @author David Rodriguez
 */
@Component
public class JdbcConfiguration {

    private String username;
    private String password;
    private String driverClassName;
    private String url;

    public JdbcConfiguration(
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password,
            @Value("${jdbc.driverClassName}") String driverClassName
    ) {
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.url = url;
    }

    String getUrl() {
        return url;
    }

    String getDriverClassName() {
        return driverClassName;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
