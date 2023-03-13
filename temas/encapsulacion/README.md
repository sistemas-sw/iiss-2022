
## Encapsulación de datos en C#

La encapsulación consiste en proteger los datos y garantizar que se acceda a ellos a través de métodos específicos. En C# se implementa usando get, set e init.

### get y set

Get se utiliza para recibir un atributo de la clase y set para definirlo. Se hacen de forma segura a través de este método, por lo tanto es proteger el dato ya que sólo se accede al atributo a través de un método.


### init

Se utiliza para crear propiedades de solo lectura que se pueden establecer en el momento de la creación del objeto, pero que no se pueden cambiar posteriormente. Una vez que se inicializa una propiedad con init, no se puede cambiar su valor. Si intentamos cambiar el valor de una propiedad inicializada con init, dará error. Es una forma de encapsular los datos ya que lo estamos protegiendo para que no se modifique.


## Clase circulo

He creado una clase llamada circulo, que tiene una variable privada llamada radio. La encapsulacion en C# consiste en que sólo podemos acceder a ella a través del get y el set del método Radio. Dentro del set sólo se puede modificar el nombre si cumple unas condiciones, lo que ayuda a garantizar la seguridad. Además, el radio usa init, lo que significa que no puede modificarse después de haber inicializado el objeto.


### Compilacion:

He tenido que instalar .NET.

Enlace oficial: https://dotnet.microsoft.com/es-es/

Comandos para ejecutar el programa una vez instalado:

```console
csc circulo.cs
mono circulo.exe
```


### Ejecución del código

Cuando ejecutamos, la salida es:

```console
Error, usa un nombre mas significativo
El nombre del circulo es: circulo1
El área del círculo es: 78,5398163397448
El perímetro del círculo es: 31,4159265358979
```
Esto es así porque le damos de nombre al círculo "circulo1", y luego intentamos darle de nombre "circulo" pero no cumple con la condición del set, por lo que se lanza una excepción. Finalmente, usamos el get del nombre y los métodos del área y el perímetro.

```java
public static void Main(string[] args)
{
        circulo c = new circulo(5.0);
       
        c.nombre = "circulo1";

            try {
                c.Nombre = "circulo";
            }
            catch (Exception e) { Console.WriteLine(e.Message); } // Imprime "Error, usa un nombre más significativo"
                
            Console.WriteLine("El nombre del circulo es: {0}", c.Nombre);
            Console.WriteLine("El área del círculo es: {0}", c.Area());
            Console.WriteLine("El perímetro del círculo es: {0}", c.Perimetro());
}
```

