package com.study.ssm.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.study.ssm.service", "com.study.ssm.aop"})
@PropertySource("classpath:jdbc.properties")
@Import({DataSourceConfig.class, MyBatisConfig.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
