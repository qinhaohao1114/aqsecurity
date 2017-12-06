package com.aq.school.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidDBConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${school.datasource.url}")
    private String dbUrl;

    @Value("${school.datasource.username}")
    private String username;

    @Value("${school.datasource.password}")
    private String password;

    @Value("${school.datasource.driverClassName}")
    private String driverClassName;

    @Value("${school.datasource.initialSize}")
    private int initialSize;

    @Value("${school.datasource.minIdle}")
    private int minIdle;

    @Value("${school.datasource.maxActive}")
    private int maxActive;

    @Value("${school.datasource.maxWait}")
    private int maxWait;

    @Value("${school.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${school.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${school.datasource.validationQuery}")
    private String validationQuery;

    @Value("${school.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${school.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${school.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${school.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${school.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${school.datasource.filters}")
    private String filters;

    @Value("{school.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "schoolDataSource")     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

}
