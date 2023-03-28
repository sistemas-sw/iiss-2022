import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import java.lang.reflect.Method;

public class LoggingAspect extends AbstractModule {
  @Override
  protected void configure() {
    bindInterceptor(
      Matchers.any(),
      Matchers.annotatedWith(Interceptor.class),
      invocation -> {
        Method method = invocation.getMethod();
        System.out.println(
          "LoggingAspect: " + method.getName() + " was called."
        );
        return invocation.proceed();
      }
    );
  }
}
