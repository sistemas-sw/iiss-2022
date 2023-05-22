package maria;

public class Point{
    private int x = 0, y = 0;
  
    int getX() { return x; }
    int getY() { return y; }
  
    @Interceptor
    void setX(int x) { this.x = x; }

    @Interceptor
    void setY(int y) { this.y = y; }
}