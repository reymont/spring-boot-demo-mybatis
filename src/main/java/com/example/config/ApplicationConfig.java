package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by Zhangkh on 2017/3/6.
 */
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan({"com.example.controllers", "com.example.services"})
@MapperScan(basePackages = "com.example.mappers")
@PropertySource(value = "classpath:/com/example/data/config/data.properties",
        ignoreResourceNotFound = true)
public class ApplicationConfig {
    @Bean
    @Profile("default")
    DataSource dataSource(Environment env, ApplicationContext context) throws IOException {
        Properties properties = new Properties();
        String file = env.getProperty("com.example.data.config.file");
        System.out.println("filename:" + file);
        properties.load(context.getResource(file).getInputStream());
        setPropsFromEnv("hikari", properties, env);
        return new HikariDataSource(new HikariConfig(properties));
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean
    ExecutorType executorType(Environment environment) {
        String executorType = environment.getProperty("com.example.data.mybatis.executorType",
                "SIMPLE");
        ExecutorType type = ExecutorType.valueOf(executorType);
        return type == null ? ExecutorType.SIMPLE : type;
    }

    @Bean
    @Scope("prototype")
    SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return new SqlSessionTemplate(sqlSessionFactory, executorType);
    }

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    private void setPropsFromEnv(String prefix, Properties props, Environment env) {
        Collections.list(props.keys()).stream().forEach(key -> {
            String name = key.toString();
            String envName = prefix + '_' + name;
            String envAltName = prefix + '_' + name.replace('.', '_');

            if (env.containsProperty(envName)) {
                props.setProperty(name, env.getProperty(envName));
            } else if (env.containsProperty(envAltName)) {
                props.setProperty(name, env.getProperty(envAltName));
            }
        });
    }
}
