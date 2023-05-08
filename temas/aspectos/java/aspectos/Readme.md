# Práctica Apectos Java

## Compilación y ejecución del proyecto

Para compilar el proyecto maven usaremos el siguiente comando.

```shell
mvn compile
```

Para ejecutar el proyecto usaremos el comando:

```shell
mvn exec:java -Dexec.mainClass="es.uca.aspectos.Main"
```

## Ejemplo

En este caso realizaremos la orientación a aspectos usando `Spring AOP` y haciendo uso de las anotaciones que nos provee `aspectJ`. En primer lugar creamos las clases `Point` y `Line`

### Point.java

```java
package es.uca.aspectos;

public class Point {
    private int x = 0, y = 0;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }
}
```

### Line.java

```java
package es.uca.aspectos;

public class Line {
    private Point p1, p2;

    Point getP1() {
        return p1;
    }

    Point getP2() {
        return p2;
    }

    void setP1(Point p1) {
        this.p1 = p1;
    }

    void setP2(Point p2) {
        this.p2 = p2;
    }
}
```

Posteriormente creamos el aspecto `MoveTracking`

### MoveTracking.java

```java
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
```

En el código anterior establecemos MoveTracking como un aspecto con el uso de la anotacións `@Aspect`, dentro de la clase creamos un `Pointcut` cuyo nombre es `move()` que se activará una vez se ejecuten los métodos set de las clases `Point`y `Line`. con la anotación `@After` establecemos el código a ejecutar una vez el `Pointcut` `move()` tenga lugar. En este caso se establecerá la flag a `true`.

### Main.java

```java
package es.uca.aspectos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

 public static void main(String[] args) {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  // Obtener una instancia de la clase Line
  Line line = context.getBean(Line.class);

  // Obtener una instancia de la clase Point
  Point point = context.getBean(Point.class);

  // Realizar un movimiento en la línea y en el punto
  line.setP1(point);
  point.setX(10);

  // Verificar si se ha realizado un movimiento y limpiar la bandera
  MoveTracking moveTracking = context.getBean(MoveTracking.class);
  if (moveTracking.testAndClear()) {
   System.out.println("Se ha realizado un movimiento");
  } else {
   System.out.println("No se ha realizado ningún movimiento");
  }

  // Cerrar el contexto de la aplicación
  context.close();
 }
}
```

Como estamos usando los beans de Spring necesitamos el `applicationContext.xml`

### applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>  
    <beans xmlns="http://www.springframework.org/schema/beans"  
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xmlns:aop="http://www.springframework.org/schema/aop"   
           xsi:schemaLocation="http://www.springframework.org/schema/beans   
           http://www.springframework.org/schema/beans/spring-beans.xsd   
           http://www.springframework.org/schema/aop   
           http://www.springframework.org/schema/aop/spring-aop.xsd">  
      
      
        <bean id="Line" class="es.uca.aspectos.Line"></bean>  
        <bean id="Point" class="es.uca.aspectos.Point"></bean>  
        <bean id="MoveTracking" class="es.uca.aspectos.MoveTracking"></bean>  
          
        <bean class="org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator"></bean>  
              
    </beans>  
```
