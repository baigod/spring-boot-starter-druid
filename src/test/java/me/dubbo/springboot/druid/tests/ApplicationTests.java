package me.dubbo.springboot.druid.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import me.douboo.springboot.druid.EnableDruid;

@RunWith(SpringRunner.class)
@EnableDruid
@PropertySource("classpath:application.properties")
public class ApplicationTests {

	protected final Logger LOG = LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testCUD() throws Exception {
		Integer obj = jdbcTemplate.queryForObject("select 1", Integer.class);
		System.out.println(obj);
		assert obj != null;
	}

}
