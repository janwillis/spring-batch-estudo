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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.com.santander.spring.batch.repository.mysql",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef ="mysqlTransactionManager"
)
public class MysqlDataSourceConfig {

    final static String PACKAGE_ENTITY_SOURCE = "br.com.santander.spring.batch.domain.entity.mysql";

    @Bean(name = "mysqlDataSource" )
    @ConfigurationProperties(prefix = "spring.datasource.mysql-datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource dataSource, EntityManagerFactoryBuilder entityManagerFactoryBuilder
    ) {
        return entityManagerFactoryBuilder//
                .dataSource(dataSource)//
                .packages(PACKAGE_ENTITY_SOURCE)//
                .persistenceUnit("mysql")
                .properties(mysqlHibernateProperties())
                .build();
    }


    private Map<String, Object> mysqlHibernateProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return props;
    }

    @Bean(name ="mysqlTransactionManager" )
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(mysqlEntityManagerFactory.getObject()));
    }
}
