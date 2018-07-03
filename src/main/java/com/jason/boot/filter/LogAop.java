package com.jason.boot.filter;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jason.boot.entity.Result;
/**
 * 日志打印aop
 * @author 宁无敌
 *
 */
@Aspect
@Component
public class LogAop {
	private static final Logger log = LoggerFactory.getLogger(LogAop.class);

	@Pointcut(value = "execution(public * com.jason.boot.controller..*.*(..))" )
	public void logPointCut() {
	};

/*	@Before(value="logPointCut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		log.info("------"+request.getRequestURL()+"------"+request.getMethod()+"------start------");
	}*/
	@Around(value="logPointCut()")
	public Object doAround(ProceedingJoinPoint  joinPoint){
		Object result = new Object();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		try{
			log.info("------"+request.getRequestURL()+"------"+request.getMethod()+"------start------");
			result = joinPoint.proceed();
			if(result instanceof Result){//如果返回是Result类型
				log.info("result："+result);
			}else{//如果是其他类型
				
			}
			log.info("------"+request.getRequestURL()+"------"+request.getMethod()+"------end------");
		}catch(RuntimeException  e){
			log.info("运行时异常，进行事务回滚！");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result = new Result<Object>(Result.ERROR_CODE,Result.ERROR_MSG);
			e.printStackTrace();
			log.info("result："+result);
			log.info("------"+request.getRequestURL()+"------"+request.getMethod()+"------end------");
		}catch(Throwable  e){
			result = new Result<Object>(Result.ERROR_CODE,Result.ERROR_MSG);
			e.printStackTrace();
			log.info("result："+result);
			log.info("------"+request.getRequestURL()+"------"+request.getMethod()+"------end------");
		}
		return result;
	}

}
