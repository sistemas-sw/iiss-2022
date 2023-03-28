import com.google.inject.AbstractModule;

public class MyAppModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Line.class);
    bind(Point.class);
    bindInterceptor(LoggingAspect.class);
  }
}
