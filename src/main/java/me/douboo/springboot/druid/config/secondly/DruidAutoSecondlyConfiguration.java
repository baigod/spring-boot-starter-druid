package me.douboo.springboot.druid.config.secondly;

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

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@EnableConfigurationProperties(DruidSecondlyProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoSecondlyConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(DruidAutoSecondlyConfiguration.class);

	@Autowired
	private DruidSecondlyProperties druidSecondlyProperties;

	@Bean
	public DataSource secondlyDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setName(druidSecondlyProperties.getName());
		dataSource.setUrl(druidSecondlyProperties.getUrl());
		dataSource.setUsername(druidSecondlyProperties.getUsername());
		dataSource.setPassword(druidSecondlyProperties.getPassword());
		if (druidSecondlyProperties.getInitialSize() > 0) {
			dataSource.setInitialSize(druidSecondlyProperties.getInitialSize());
			logger.debug("setInitialSize --->" + druidSecondlyProperties.getInitialSize());
		}
		if (druidSecondlyProperties.getMinIdle() > 0) {
			dataSource.setMinIdle(druidSecondlyProperties.getMinIdle());
			logger.debug("setInitialSize --->" + druidSecondlyProperties.getInitialSize());
		}
		if (druidSecondlyProperties.getMaxActive() > 0) {
			dataSource.setMaxActive(druidSecondlyProperties.getMaxActive());
			logger.debug("setMaxActive --->" + druidSecondlyProperties.getMaxActive());
		}
		if (druidSecondlyProperties.getTestOnBorrow() != null) {
			dataSource.setTestOnBorrow(druidSecondlyProperties.getTestOnBorrow());
			logger.debug("setTestOnBorrow --->" + druidSecondlyProperties.getTestOnBorrow());
		}
		if (druidSecondlyProperties.getMaxWait() > 0) {
			dataSource.setMaxWait(druidSecondlyProperties.getMaxWait());
			logger.debug("setMaxWait --->" + druidSecondlyProperties.getMaxWait());
		}
		if (druidSecondlyProperties.getTimeBetweenEvictionRunsMillis() > 0) {
			dataSource.setTimeBetweenEvictionRunsMillis(druidSecondlyProperties.getTimeBetweenEvictionRunsMillis());
			logger.debug("setTimeBetweenEvictionRunsMillis --->" + druidSecondlyProperties.getTimeBetweenEvictionRunsMillis());
		}
		if (druidSecondlyProperties.getMinEvictableIdleTimeMillis() > 0) {
			dataSource.setMinEvictableIdleTimeMillis(druidSecondlyProperties.getMinEvictableIdleTimeMillis());
			logger.debug("setMinEvictableIdleTimeMillis --->" + druidSecondlyProperties.getMinEvictableIdleTimeMillis());
		}
		if (druidSecondlyProperties.getValidationQuery() != null) {
			dataSource.setValidationQuery(druidSecondlyProperties.getValidationQuery());
			logger.debug("setValidationQuery --->" + druidSecondlyProperties.getValidationQuery());
		}
		if (druidSecondlyProperties.getTestWhileIdle() != null) {
			dataSource.setTestWhileIdle(druidSecondlyProperties.getTestWhileIdle());
			logger.debug("setTestWhileIdle --->" + druidSecondlyProperties.getTestWhileIdle());
		}
		if (druidSecondlyProperties.getTestOnReturn() != null) {
			dataSource.setTestOnReturn(druidSecondlyProperties.getTestOnReturn());
			logger.debug("setTestOnReturn --->" + druidSecondlyProperties.getTestOnReturn());
		}
		if (druidSecondlyProperties.getPoolPreparedStatements() != null) {
			dataSource.setPoolPreparedStatements(druidSecondlyProperties.getPoolPreparedStatements());
			logger.debug("setPoolPreparedStatements --->" + druidSecondlyProperties.getPoolPreparedStatements());
		}
		if (druidSecondlyProperties.getMaxPoolPreparedStatementPerConnectionSize() > 0) {
			dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidSecondlyProperties.getMaxPoolPreparedStatementPerConnectionSize());
			logger.debug("setMaxPoolPreparedStatementPerConnectionSize --->" + druidSecondlyProperties.getMaxPoolPreparedStatementPerConnectionSize());
		}
		if (druidSecondlyProperties.getFilters() != null) {
			try {
				dataSource.setFilters(druidSecondlyProperties.getFilters());
				logger.debug("setFilters --->" + druidSecondlyProperties.getFilters());
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("setInitialSize error");
			}
		}
		if (druidSecondlyProperties.getConnectionProperties() != null) {
			dataSource.setConnectionProperties(druidSecondlyProperties.getConnectionProperties());
			logger.debug("setConnectionProperties --->" + druidSecondlyProperties.getConnectionProperties());
		}

		try {
			dataSource.init();
			logger.debug("dataSource.init()");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dataSource;
	}

}
