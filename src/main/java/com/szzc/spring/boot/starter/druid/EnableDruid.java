package com.szzc.spring.boot.starter.druid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.szzc.spring.boot.starter.druid.config.DruidAutoConfiguration;
import com.szzc.spring.boot.starter.druid.config.DruidMonitorAutoConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ DruidMonitorAutoConfiguration.class, DruidAutoConfiguration.class })
@Documented
public @interface EnableDruid {
}
