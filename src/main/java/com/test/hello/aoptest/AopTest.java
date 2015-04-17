package com.test.hello.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@Aspect
public class AopTest {
	
	/**方式1 ：通过声明切面标识  anoterPointCut()		**/
	
	@Pointcut("execution(* com.test.hello.MessagePrinter.printMessage(..))") //切面表达式
	public void anoterPointCut(){} //切面标识（切面签名类似唯一标志 是一个空方法用来表示切面） 
	 
	@Before("com.test.hello.aoptest.AopTest.anoterPointCut()") //在这个切面之前执行
	public void dobeforeIt(JoinPoint jp) //JoinPoint能够获取函数的参数等一系列属性
	{
		System.out.println(jp.getArgs()[0]); //获取切面函数的参数
		System.out.println("Before it runs");
	}
	
	
	/**方式2：直接通过execution指定切面表达式    
	@Before("execution(* com.test.hello.MessagePrinter.printMessage())")
	public void dobeforeIt()
	{
		System.out.println("Before it runs");
	}
	**/
}
