
## Herencia en C#

La herencia sirve para que una nueva clase herede las propiedades y métodos de la clase base. En C# creamos una clase nueva y detrás del nombre escribimos dos puntos seguidos del nombre de la clase base.

También usamos palabras clave:
+ interface: una interfaz es un conjunto de comportamientos que una clase debe implementar pero no proporciona la implementación, se define en las clases hijas.
+ base: se usa en una clase derivada para llamar a un constructor.

+ override: se usa en una clase derivada para reemplazar la implementación de un método de la clase base.
```C#
public override void Luchar() { Console.WriteLine("¡Luchando como un héroe!"); }
```
+ virtual: se usa en una clase base para indicar que un método puede ser reemplazado en una clase derivada utilizando la palabra clave override.
```C#
public virtual void Luchar() { Console.WriteLine("¡Luchando!"); }


### Compilacion:

He tenido que instalar .NET.

Enlace oficial: https://dotnet.microsoft.com/es-es/

Comandos para ejecutar el programa una vez instalado:

```console
csc aventura.cs
mono aventura.exe
