package maria;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import org.aopalliance.intercept.MethodInterceptor;

public class MyAppModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Line.class);
    bind(Point.class);
    bindInterceptor(
      Matchers.any(),
      Matchers.annotatedWith(Interceptor.class),
      new LoggingAspect() // Aquí se usa la instancia de LoggingAspect
    );
  }
}