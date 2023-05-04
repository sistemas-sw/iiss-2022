# Observables en C\#

## Construcción y ejecución del software

Para ejecutar el software correspondiente hay que usar el comando.
`dotnet run`

## Ejemplo

En el siguiente código de ejemplo vamos a mostrar la implementación y uso de observables en C# haciendo uso de la API de `System.Reactive`

```csharp
using System;
using System.Reactive.Subjects;

public class Program
{
    static void Main(string[] args)
    {
        var numeros = new Subject<int>();

        numeros.Subscribe(
            numero => Console.WriteLine($"Número emitido: {numero}"),
            error => Console.WriteLine($"Error: {error}"),
            () => Console.WriteLine("Secuencia finalizada")
        );

        for (int i = 1; i <= 5; i++) 
        {
            numeros.OnNext(i);
        }

        numeros.OnCompleted();

        Console.ReadLine(); 
    }
}

```

En este ejemplo usamos la clase Subject, la cual es un oberservable al que nos podemos subscribir. Al método subscribe le pasamos tres funciones lambda, una para `OnNext`, otra para `OnError` y otra para `OnCompleted`. Esta función es un subscriptor, en caso de querer añadir más subscriptores simplemente llamaremos de nuevo al método Subscribe, pasándo otras tres lambdas. Posteriormente recorremos una secuencia de número del uno al 5 emitiendo un evento en cada iteración. Podemos ver que se imprime por pantalla el método. Al final se llama a la función `OnCompleted`, que ejecuta la función establecida de todos los subscriptores
