/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.db.configuration.hibernate;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author mac-daniel
 */
@Configuration
@ComponentScan(HibernateConstants.HIBERNATE_PACKAGE_SCAN)
@EnableTransactionManagement
public class HibernateConfig {

  private static final Log LOG = LogFactory.getLog(HibernateConfig.class);

  @Autowired
  private HibernatePropertiesConfig hibernatePropertiesConfig;

  @Bean
  public HibernateTemplate hibernateTemplate() {
    return new HibernateTemplate(sessionFactory());
  }

  @Bean
  public SessionFactory sessionFactory() {
    LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
    lsfb.setDataSource(getDataSource());
    lsfb.setPackagesToScan(HibernateConstants.HIBERNATE_PACKAGE_SCAN_DTO);
    lsfb.setHibernateProperties(hibernateProperties());
    try {
      lsfb.afterPropertiesSet();
    } catch (IOException e) {
      LOG.error(e.getMessage());
    }
    return lsfb.getObject();
  }

  @Bean(destroyMethod = "")
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(hibernatePropertiesConfig.getDataBaseDriver());
    dataSource.setUrl(hibernatePropertiesConfig.getDataBaseUrl());
    dataSource.setUsername(hibernatePropertiesConfig.getDataBaseUser());
    dataSource.setPassword(hibernatePropertiesConfig.getDataBasePassword());
    return dataSource;
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager() {
    return new HibernateTransactionManager(sessionFactory());
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put(HibernateConstants.HIBERNATE_DIALECT_PROPERTY, hibernatePropertiesConfig.getHibernateDialect());
    properties.put(HibernateConstants.HIBERNATE_SHOW_SQL_PROPERTY, hibernatePropertiesConfig.getHibernateShowSql());
    properties.put(HibernateConstants.HIBERNATE_FORMAT_SQL_PROPERTY, hibernatePropertiesConfig.getHiberntaFormatSql());
    properties.put(HibernateConstants.HIBERNATE_CONNECTION_POOL_SIZE_PROPERTY, hibernatePropertiesConfig.getHibernateConnectionPoolSize());
    properties.put(HibernateConstants.HIBERNATE_CURRENT_SESSION_CONTEXT_PROPERTY, hibernatePropertiesConfig.getHibernateCurrentSesssionContextClass());
    properties.put(HibernateConstants.HIBERNATE_CONNECTION_AUTOCOMMIT_PROPERTY, hibernatePropertiesConfig.getHibernateConnectionAutocommit());
    properties.put(HibernateConstants.HIBERNATE_ID_NEW_GENERATOR_MAPPINGS, hibernatePropertiesConfig.getHibernateIdNewGeneratorMappings());
    return properties;
  }

}
