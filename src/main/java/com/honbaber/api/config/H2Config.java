package com.honbaber.api.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Config {
	@Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }
}
