package org.fi.spring.fourthspringjdbc.config;

import javax.sql.DataSource;

import org.fi.spring.fourthspringjdbc.DAO.CategoryDAO;
import org.fi.spring.fourthspringjdbc.DAO.CategoryDAOImpl;
import org.fi.spring.fourthspringjdbc.beans.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfigurator {
	@Bean
	public DataSource dataSource(@Value("${dataSource.driverclass}")String driverClass,@Value("${dataSource.url}")String url, @Value("${dataSource.username}")String dbuser,@Value("${dataSource.password}")String dbPwd)
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(dbuser);
		dataSource.setDriverClassName(driverClass);
		dataSource.setPassword(dbPwd);
		dataSource.setUrl(url);
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public CategoryDAO objCategoryDAO() {
		return new CategoryDAOImpl();
	}
	@Bean
	public Category objCategory()
	{
		return new Category();
	}
}
