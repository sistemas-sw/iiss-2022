# Refactoring

He hecho refactoring porque he mejorado el código sin cambiar la funcionalidad ni añadir nada nuevo.

Mejoras:

+ Código innecesario: la línea `using System.Runtime.CompilerServices;` era innecesaria porque ya había añadido `namespace System.Runtime.CompilerServices { public static class IsExternalInit {} } `

+ Cambio de nombres según la convención Pascal case
    + He cambiado el nombre de la clase circulo por Circulo.
    + He cambiado los atributos nombre y radio 
    por: Nombre y Radio.
    + He cambiado los métodos Area, Perimetro y Nombre por: ObtenerArea, ObtenerPerimetro y ObtenerNombre. Así se sabe mejor qué hacen y no se confunden con los atributos.


+ Antes la clase Circulo estaba fuera de `namespace Application` y debería estar dentro.
