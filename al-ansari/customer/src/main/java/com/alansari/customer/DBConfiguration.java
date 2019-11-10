package com.alansari.customer;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DBConfiguration {
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	   LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	   sessionFactory.setDataSource(dataSource());
	   sessionFactory.setPackagesToScan(
	       new String[] { "com.alansari.customer.persistence" }
	   );
	   sessionFactory.setHibernateProperties(hibernateProperties());

	   return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/alansari");
	    dataSource.setUsername("root");
	    dataSource.setPassword("Deoghar@123");
	    return dataSource;
	}

	Properties hibernateProperties() 
	{
		return new Properties() 
		{
			{
				setProperty("hibernate.hbm2ddl.auto", "create");
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect"); 
				setProperty("hibernate.show_sql","true");
			}
		}; 
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
	    SessionFactory sessionFactory) {
	    HibernateTransactionManager txManager = new HibernateTransactionManager();
	    txManager.setSessionFactory(sessionFactory);
	    return txManager;
	}
}
