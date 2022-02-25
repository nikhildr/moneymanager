package com.skyfall.money.manager.logger;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    /// logs the method of below packages
    @Pointcut("within(com.skyfall.money.manager.controller..*) || within(com.skyfall.money.manager.serviceimpl..*) "
            + "|| within(com.skyfall.money.manager.util..*)")

    public void controller() {

    }

    // logs the entry method
    @Before("controller()")
    public void logBefore(JoinPoint joinPoint) {

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        log.info("enter {}.{}() {}", className, methodName, Arrays.toString(joinPoint.getArgs()));
    }

    // and return a value
    // logs the exit method with return value
    @AfterReturning(pointcut = "controller()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String returnValue = this.getValue(result);
        log.info("exit {}.{}() {}", className, methodName, returnValue);
    }

    private String getValue(Object result) {
        String returnValue = null;
        if (null != result) {
            if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
                returnValue = ReflectionToStringBuilder.toString(result);
            } else {
                returnValue = result.toString();
            }
        }
        return returnValue;
    }
}