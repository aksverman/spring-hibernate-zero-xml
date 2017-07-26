package com.rudra.aks;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rudra.aks.bo.TestBO;

@Configuration
@ComponentScan(basePackages = "com.rudra.aks.")
@EnableWebMvc
public class AppConfiguration extends	WebMvcConfigurerAdapter {

	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate()	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate(getSessionFactory());
	    hibernateTemplate.setCheckWriteOperations(false);
		return hibernateTemplate;
	}	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(getSessionFactory());
	    //transactionManager.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
	    return transactionManager;
	}
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
	    sessionBuilder.addAnnotatedClasses(TestBO.class);
	    return sessionBuilder.buildSessionFactory();
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://10.98.8.100:3306/security_dev?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	    dataSource.setUsername("devuser");
	    dataSource.setPassword("leo$123");
	 
	    return dataSource;
	}
	
	
}
