package br.com.santander.spring.batch.config.datasource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.com.santander.spring.batch.repository.postgres",
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager"

)
public class PostGreSqlDataSourceConfig {

    final static String PACKAGE_ENTITY_SOURCE = "br.com.santander.spring.batch.domain.entity.postgres";

    @Primary // <-- precisamos declarar uma das fontes de dados como @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres-datasource")
    public DataSource postgresDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary // <-- precisamos declarar uma das fontes de dados como @Primary
    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            @Qualifier("postgresDataSource")DataSource dataSource, EntityManagerFactoryBuilder entityManagerFactoryBuilder
            ){
        return  entityManagerFactoryBuilder.dataSource(dataSource)//
                .packages(PACKAGE_ENTITY_SOURCE)//
                .persistenceUnit("postgres")//newInqEntityManagerFactory
                .properties(postgresHibernateProperties())
                .build();
    }

    private Map<String, Object> postgresHibernateProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return props;
    }

    @Primary // <-- precisamos declarar uma das fontes de dados como @Primary
    @Bean(name ="postgresTransactionManager" )
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory
    ){
        return new JpaTransactionManager(Objects.requireNonNull(postgresEntityManagerFactory.getObject()));


    }
}
