package es.uca.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MoveTracking {
    private boolean flag = false;

    public boolean testAndClear() {
        boolean result = flag;
        flag = false;
        return result;
    }

    @Pointcut("execution(void Line.setP1(Point)) || " +
            "execution(void Line.setP2(Point)) || " +
            "execution(void Point.setX(int)) || " +
            "execution(void Point.setY(int))")
    public void move() {

    }

    @After("move()")
    public void afterMove(JoinPoint jp) {
        flag = true;
    }
}
