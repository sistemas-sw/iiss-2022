package maria;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAspect implements MethodInterceptor {
  
 @Override 
  public Object invoke(MethodInvocation invocation) throws Throwable {
    String methodName = invocation.getMethod().getName();
    System.out.println("LoggingAspect: " + methodName + " was called.");
    return invocation.proceed();
  }
}

