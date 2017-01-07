package com.springboot.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.example.exception.LoginException;

@Aspect
@Component
public class SampleAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleAspect.class);
	
	@Value("${aspect.retry.count}")
	Integer retryCount=3;
	
	@Around(value = "@annotation(loginRequired)", argNames = "loginRequired")
	public Object login(ProceedingJoinPoint pjp, LoginRequired loginRequired) throws Throwable{
		LOGGER.info("In SampleAspect");
		String username = loginRequired.username();
		LOGGER.info("SampleAspect:: userame = " + username);
		int i = 1;
		
		do{
			LOGGER.info("SampleAspect::Retry :" + i);
			try {
				Object o = pjp.proceed();
				return o;
			} catch (LoginException e) {
				LOGGER.error("SampleAspect:: LoginException", e);
			} catch(Throwable e){
				LOGGER.error("SampleAspect:: Error", e);
				throw e;
			}
			
			LOGGER.info("SampleAspect::After catch blocks");
		}while(i++<=retryCount);
		
		LOGGER.info("SampleAspect:: Around Complete");
		return null;
	}
}
