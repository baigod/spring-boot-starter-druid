package me.douboo.springboot.druid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import me.douboo.springboot.druid.config.DruidAutoConfiguration;
import me.douboo.springboot.druid.config.DruidMonitorAutoConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ DruidMonitorAutoConfiguration.class, DruidAutoConfiguration.class })
@Documented
public @interface EnableDruid {
}
