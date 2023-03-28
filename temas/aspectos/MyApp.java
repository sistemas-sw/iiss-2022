import com.google.inject.Guice;
import com.google.inject.Injector;

public class MyApp {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new MyAppModule());
    Line line = injector.getInstance(Line.class);
    Point point = injector.getInstance(Point.class);

    line.setP1(new Point());
    line.setP2(new Point());
    point.setX(10);
    point.setY(20);
  }
}
