package com.szzc.spring.boot.starter.druid.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@EnableConfigurationProperties(DruidProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(DruidAutoConfiguration.class);

	@Autowired
	private DruidProperties properties;

	@Bean
	@Primary
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setName(properties.getName());
		dataSource.setUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		if (properties.getInitialSize() > 0) {
			dataSource.setInitialSize(properties.getInitialSize());
			logger.debug("setInitialSize --->" + properties.getInitialSize());
		}
		if (properties.getMinIdle() > 0) {
			dataSource.setMinIdle(properties.getMinIdle());
			logger.debug("setInitialSize --->" + properties.getInitialSize());
		}
		if (properties.getMaxActive() > 0) {
			dataSource.setMaxActive(properties.getMaxActive());
			logger.debug("setMaxActive --->" + properties.getMaxActive());
		}
		if (properties.getTestOnBorrow() != null) {
			dataSource.setTestOnBorrow(properties.getTestOnBorrow());
			logger.debug("setTestOnBorrow --->" + properties.getTestOnBorrow());
		}
		if (properties.getMaxWait() > 0) {
			dataSource.setMaxWait(properties.getMaxWait());
			logger.debug("setMaxWait --->" + properties.getMaxWait());
		}
		if (properties.getTimeBetweenEvictionRunsMillis() > 0) {
			dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
			logger.debug("setTimeBetweenEvictionRunsMillis --->" + properties.getTimeBetweenEvictionRunsMillis());
		}
		if (properties.getMinEvictableIdleTimeMillis() > 0) {
			dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
			logger.debug("setMinEvictableIdleTimeMillis --->" + properties.getMinEvictableIdleTimeMillis());
		}
		if (properties.getValidationQuery() != null) {
			dataSource.setValidationQuery(properties.getValidationQuery());
			logger.debug("setValidationQuery --->" + properties.getValidationQuery());
		}
		if (properties.getTestWhileIdle() != null) {
			dataSource.setTestWhileIdle(properties.getTestWhileIdle());
			logger.debug("setTestWhileIdle --->" + properties.getTestWhileIdle());
		}
		if (properties.getTestOnReturn() != null) {
			dataSource.setTestOnReturn(properties.getTestOnReturn());
			logger.debug("setTestOnReturn --->" + properties.getTestOnReturn());
		}
		if (properties.getPoolPreparedStatements() != null) {
			dataSource.setPoolPreparedStatements(properties.getPoolPreparedStatements());
			logger.debug("setPoolPreparedStatements --->" + properties.getPoolPreparedStatements());
		}
		if (properties.getMaxPoolPreparedStatementPerConnectionSize() > 0) {
			dataSource.setMaxPoolPreparedStatementPerConnectionSize(
					properties.getMaxPoolPreparedStatementPerConnectionSize());
			logger.debug("setMaxPoolPreparedStatementPerConnectionSize --->"
					+ properties.getMaxPoolPreparedStatementPerConnectionSize());
		}
		if (properties.getFilters() != null) {
			try {
				dataSource.setFilters(properties.getFilters());
				logger.debug("setFilters --->" + properties.getFilters());
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("setInitialSize error");
			}
		}
		if (properties.getConnectionProperties() != null) {
			dataSource.setConnectionProperties(properties.getConnectionProperties());
			logger.debug("setConnectionProperties --->" + properties.getConnectionProperties());
		}

		try {
			dataSource.init();
			logger.debug("dataSource.init()");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dataSource;
	}

	@Bean
	public DruidStatInterceptor druidStatInterceptor() {
		return new DruidStatInterceptor();
	}
}
