/*
 * package com.legatohealth.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * @Configuration public class DataSourceConfiguration {
 * 
 * @Value("${driver.class}") private String driverClass;
 * 
 * @Value("${url}") private String url;
 * 
 * @Value("${user}") private String username;
 * 
 * @Value("${password}") private String password;
 * 
 * 
 * @Bean public DataSource datasource() { return
 * DataSourceBuilder.create().driverClassName(driverClass)
 * .url(url).username(username).password(password).build(); }
 * 
 * 
 * public String getDriverClass() {
 * System.out.println("driver class ===== "+driverClass); return driverClass; }
 * 
 * }
 */