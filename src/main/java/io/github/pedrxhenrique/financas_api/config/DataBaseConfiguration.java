package io.github.pedrxhenrique.financas_api.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {

    @Value("jdbc:postgresql://localhost:5433/financas_db")
    String url;
    @Value("postgres")
    String username;
    @Value("123456")
    String password;
    @Value("org.postgresql.Driver")
    String driver;

    @Bean
    public DataSource HikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }
}
