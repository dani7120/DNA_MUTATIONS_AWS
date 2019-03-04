/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.mutations.db.configuration.hibernate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author dsanche1
 */
@Component
@PropertySource("classpath:hibernate.properties")
public class HibernatePropertiesConfig {

  @Value("${database.type}")
  @Getter
  @Setter
  private String dataBaseType;

  @Value("${database.driver}")
  @Getter
  @Setter
  private String dataBaseDriver;

  @Value("${database.url}")
  @Getter
  @Setter
  private String dataBaseUrl;

  @Value("${database.user}")
  @Getter
  @Setter
  private String dataBaseUser;

  @Value("${database.password}")
  @Getter
  @Setter
  private String dataBasePassword;

  @Value("${hibernate.dialect}")
  @Getter
  @Setter
  private String hibernateDialect;

  @Value("${hibernate.show_sql}")
  @Getter
  @Setter
  private String hibernateShowSql;

  @Value("${hibernate.format_sql}")
  @Getter
  @Setter
  private String hiberntaFormatSql;

  @Value("${hibernate.current.session.context.class}")
  @Getter
  @Setter
  private String hibernateCurrentSesssionContextClass;

  @Value("${hibernate.connection.pool_size}")
  @Getter
  @Setter
  private String hibernateConnectionPoolSize;

  @Value("${hibernate.connection.autocommit}")
  @Getter
  @Setter
  private String hibernateConnectionAutocommit;
  
  @Value("${hibernate.id.new_generator_mappings}")
  @Getter
  @Setter
  private String hibernateIdNewGeneratorMappings;
}
