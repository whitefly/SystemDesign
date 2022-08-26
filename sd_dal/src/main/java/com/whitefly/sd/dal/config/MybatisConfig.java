package com.whitefly.sd.dal.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    @PostConstruct
    void init() {
        System.out.println("载入配置");
    }

    @Bean(name = "sdDataSource")
    public DriverManagerDataSource sdDataSource() {
        //设置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/self_system_design?createDatabaseIfNotExist=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;

    }

    @Bean(name = "sdSqlSessionFactory")
    public SqlSessionFactory sdSqlSessionFactory(@Qualifier("sdDataSource") DataSource dataSource,
                                                 @Value("classpath:mybatis-config.xml") Resource sdMybatisConfigLocation) throws Exception {
        //采用mybatis来管理会话
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(sdMybatisConfigLocation);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }



    @Bean
    public MapperScannerConfigurer sdScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sdSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.whitefly.sd.dal.mapper");
        return mapperScannerConfigurer;
    }
}
