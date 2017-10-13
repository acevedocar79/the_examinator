/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. THIS
 * SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES. THIS INFORMATION
 * SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE
 * COMPANY ITSELF.
 */
package mx.com.anzen.app.usercomponent.examinator.endpoints;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mx.com.anzen.app.usercomponent.common.jpa.model.CcsCustomerMast;

/**
 * <p>the spring-boot startup class</p>
 * 
 * @author Francois Gergaud
 * @version
 * @since
 */
@Configuration
@ComponentScan({"mx.com.anzen.app.usercomponent.endpoints", "mx.com.anzen.app.usercomponent.common"})
@EnableAutoConfiguration(exclude=WebMvcAutoConfiguration.class)
@EnableTransactionManagement
@EnableJpaRepositories({"mx.com.anzen.app.usercomponent.common.jpa.repositories"})
@EntityScan({"mx.com.anzen.app.usercomponent.common.jpa.model"})
public class Application {

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsr;
	@Value("${spring.datasource.password}")
	private String dbPsw;
	@Value("${spring.datasource.driver-class-name}")
	private String dbDrv;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.default_schema}")
	private String schema;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean
	public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		return factory;
	}

	@Bean
	public ServletRegistrationBean cxf() {
		ServletRegistrationBean result = new ServletRegistrationBean(new CXFServlet(), "/services/*");
		result.addInitParameter("config-location", "classpath:webservices-context.xml");
		return result;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(dbDrv);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUsr);
		ds.setPassword(dbPsw);
		
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(CcsCustomerMast.class.getPackage().getName());
		factory.setDataSource(dataSource());
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", dialect);
		props.setProperty("hibernate.default_schema", schema);
//		props.setProperty("hibernate.format_sql", "true");
		factory.setJpaProperties(props);
		
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		txManager.setDataSource(dataSource());
		
		return txManager;
	}
}
