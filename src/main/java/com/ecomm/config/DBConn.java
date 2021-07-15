package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.entity.Category;
import com.ecomm.entity.UserDetail;

@Configuration
@ComponentScan("com.ecomm")
@EnableTransactionManagement
public class DBConn 
{

	//1. Create a DataSource bean. DataSource is an interface in javax.sql package
	//This bean will be used to create the LocalSessionFactoryBean object.
	//This bean also will be used while we are implementing spring security.
	
	@Bean(name="datasource")
	public DataSource getMySQLDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/S2103151");
		dataSource.setUsername("root");
		dataSource.setPassword("manam4527");
		System.out.println("========= Data Source Bean Created ============");
		return dataSource;
	}
	
	//2. Create a SessionFactory bean which is from the SessionFactory of Hibernate
	//To implement this we need to create LocalSessionFactoryBuilder object

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory1()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getMySQLDataSource());
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		
		SessionFactory sessionFactory=factoryBuilder.buildSessionFactory();
		System.out.println("========= Session Factory Bean Created ============");
		return sessionFactory;
	
	}
	
	//3. Create a HibernateTransactionManager object.
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory)
	{
		System.out.println("========= Hibernate Transaction Bean Created ============");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}
