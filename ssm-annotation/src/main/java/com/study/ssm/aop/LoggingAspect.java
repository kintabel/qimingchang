package com.study.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private ThreadLocal<Instant> startTime = new ThreadLocal<>();

    // 定义切点，匹配所有public方法
    @Pointcut("execution(* com.study.ssm..*(..))")
    public void publicMethodPointcut() {}

    // 方法执行前记录开始时间
    @Before("publicMethodPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        startTime.set(Instant.now());
        logger.info("开始执行 {} 方法，参数：{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    // 方法执行后记录结束时间，并计算执行时间
    @AfterReturning(pointcut = "publicMethodPointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        Instant end = Instant.now();
        Instant start = startTime.get();
        startTime.remove();

        if (start != null) {
            Duration duration = Duration.between(start, end);
            logger.info("完成执行 {} 方法，耗时：{} ms", joinPoint.getSignature().getName(), duration.toMillis());
        }
    }
}
