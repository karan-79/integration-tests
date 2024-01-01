package com.integrationtesting.practice.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@Slf4j
public class DbConfig {

    @Value("${db.type}")
    private String dataSourceType;

    @Bean
    public DataSource dataSource(){

        return getDataSource();
    }

    private String getDriverName(DataSource ds) {
        var dsp = ((DriverManagerDataSource) ds);
        return dsp.getUrl();
    }

    private DataSource getDataSource() {
        if(dataSourceType.equals("h2")) return h2DataSource();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/e_commerce");
        dataSource.setUsername("postgres");
        dataSource.setPassword("369963");

        return dataSource;
    }

    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("e_commerce").build();
    }


}
