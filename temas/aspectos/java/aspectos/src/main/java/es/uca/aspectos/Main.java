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
