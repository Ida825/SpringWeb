package cn.et.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyConfig {

	@Value("${url}")
	private String url;
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${username1}")
	private String username;
	@Value("${password}")
	private String password;
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setUrl(url);
		dmd.setDriverClassName(driverClassName);
		dmd.setUsername(username);
		dmd.setPassword(password);
		return dmd;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	
}
