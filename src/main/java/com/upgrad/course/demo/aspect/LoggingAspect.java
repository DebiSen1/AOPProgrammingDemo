package com.upgrad.course.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
/**
 * To make it a class where aspect oriented programming features will be used mark it with @Aspect annotation
 * and to create its bean mark it with @Component*/

@Aspect
@Component
public class LoggingAspect {

/**
 * Advice - It is the action taken by an aspect at a particular join-point. Joinpoint is a point of execution of the
 * program, such as the execution of a method or the handling of an exception. In Spring AOP, a joinpoint always
 * represents a method execution.
 *
 * @Around is an advice type, which ensures that an advice can run before and after the method execution.
 * Following is the syntax of @Around advice.
 * */

    @Around("execution(* com.upgrad.course.demo..*(..))")
    public Object applyLogging(ProceedingJoinPoint joinPoint) throws Throwable{

        /**
         * while creating the business logic of the method the additional services are needed to be injected at
         * different places or points, we call such points as join points.  At a join point a new services will be
         * added into the normal flow of a business method.*/

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        System.out.println("In "+className+" entering "+methodName);

        Object result = joinPoint.proceed();

        System.out.println("In "+className+" exiting "+methodName);

        return result;
    }
}
