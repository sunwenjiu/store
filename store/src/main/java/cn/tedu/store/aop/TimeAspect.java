package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	// 切面需要执行的方法
	@Around("execution (* cn.tedu.store.service.impl.*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		// 记录开始时间
		long start = System.currentTimeMillis();
		
		// 执行业务方法，并获取返回值
		Object result = pjp.proceed();
		
		// 记录结束时间
		long end = System.currentTimeMillis();
		
		// 计算所消耗的时间
		System.err.println("耗时：" + (end-start));
		
		// 返回
		return result;
	}

}





