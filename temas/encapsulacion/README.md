
## Encapsulación de datos en C#

La encapsulación consiste en proteger los datos y garantizar que se acceda a ellos a través de métodos específicos. En C# se implementa usando get, set e init.

### get

Se utiliza para definir un método de ...(getter) ....

### set

Se utiliza para definir un método de modificación (setter) para una propiedad.


## init

Se utiliza para crear propiedades de solo lectura que se pueden establecer en el momento de la creación del objeto, pero que no se pueden cambiar posteriormente. Una vez que se inicializa una propiedad con init, no se puede cambiar su valor. Si intentamos cambiar el valor de una propiedad inicializada con init, dará error. Es una forma de encapsular los datos ya que lo estamos protegiendo para que no se modifique.


### Clase circulo

He creado una clase llamada circulo, que tiene una variable privada llamada radio. La encapsulacion en C# consiste
en que sólo podemos acceder a ella a través del get y el set del método Radio.


## Compilacion:

He tenido que instalar .NET.

Enlace oficial: https://dotnet.microsoft.com/es-es/

Comandos para ejecutar el programa una vez instalado:

```console
csc circulo.cs
mono circulo.exe
```
