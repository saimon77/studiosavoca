package it.simone.webApp.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "it.simone.webApp")
@PropertySource("classpath:app.properties")
public class HibernateConfig {

	@Autowired
	Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "it.simone.webApp.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("dataSource.driver"));
		dataSource.setUrl(env.getProperty("dataSource.url"));
		dataSource.setUsername(env.getProperty("dataSource.user"));
		dataSource.setPassword(env.getProperty("dataSource.pwd"));
		return dataSource;
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				// setProperty("hibernate.hbm2ddl.auto", "update");
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
				setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
			}
		};
	}

	@Bean
	public HibernateTransactionManager txName() throws IOException {
		HibernateTransactionManager txName = new HibernateTransactionManager();
		txName.setSessionFactory(sessionFactory().getObject());
		txName.setDataSource(dataSource());
		return txName;
	}

}