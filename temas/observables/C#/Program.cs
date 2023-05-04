using System;
using System.Reactive.Subjects;

public class Program
{
    static void Main(string[] args)
    {
        var numeros = new Subject<int>(); // Crear un Subject de números enteros

        numeros.Subscribe( // Suscribirse al observable
            numero => Console.WriteLine($"Número emitido: {numero}"),
            error => Console.WriteLine($"Error: {error}"),
            () => Console.WriteLine("Secuencia finalizada")
        );

        for (int i = 1; i <= 5; i++) // Emitir los números del 1 al 5
        {
            numeros.OnNext(i);
        }

        numeros.OnCompleted(); // Completar la secuencia

        Console.ReadLine(); // Esperar por entrada del usuario
    }
}
