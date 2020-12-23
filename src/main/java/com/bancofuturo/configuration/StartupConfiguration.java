package com.bancofuturo.configuration;

import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.usecase.service.PopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:02 PM
 *
 * @author David Rodriguez
 */
@Service
public class StartupConfiguration {

    private List<String> companies;
    private PopulatorService populatorService;
    private JdbcConfiguration jdbcConfiguration;

    private static final String PACKAGES_TO_SCAN = "com.bancofuturo";

    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_JDBC_LOB_NCC = "hibernate.jdbc.lob.non_contextual_creation";

    @Autowired
    public StartupConfiguration(
            @Value("${companies}") List<String> companies,
            JdbcConfiguration jdbcConfiguration,
            PopulatorService populatorService
    ) {
        this.companies = companies;
        this.populatorService = populatorService;
        this.jdbcConfiguration = jdbcConfiguration;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createMockDataForProviders() throws InvalidMatrixDataException {
        for (String company : companies) {
            populatorService.populateDataForCompany(company);
        }
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcConfiguration.getDriverClassName());
        dataSource.setUrl(jdbcConfiguration.getUrl());
        dataSource.setUsername(jdbcConfiguration.getUsername());
        dataSource.setPassword(jdbcConfiguration.getPassword());
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment environment, DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);

        Properties jpaProperties = new Properties();
        jpaProperties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
        jpaProperties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        jpaProperties.put(HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(HIBERNATE_FORMAT_SQL));
        jpaProperties.put(HIBERNATE_JDBC_LOB_NCC, environment.getRequiredProperty(HIBERNATE_JDBC_LOB_NCC));
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

}
