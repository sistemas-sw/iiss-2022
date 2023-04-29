# Async Await en C\#

## Uso del programa

Para ejecutar el programa basta con introducir el siguiente comando en la terminal. Teniendo instalado el sdk de .Net

```bash
dotnet run
```

## Ejemplo

Para el ejemplo de asíncronía usaremos el mecanismo de `async` y `await` de C# así como las `Tasks`.

Para que una función en C# asíncrona es necesario el uso de la keywork `async` y también es necesario que devuelva una `Task` parametrizada. Por ejemplo en caso de que queramos que nuestra función devuelva un string la función asíncrona devolvería un `Task<String>`

Cuando ejecutamos una función asíncrona esta se lanza de forma concurrente y devuelve una tarea. Cuando queramos esperar a que esa función acabe para seguir con el hilo de ejecución de nuestro programa principal usaremos la keyword `await` que devolvera el tipo de dato de que contiene la tarea, por ejemplo para un `Task<String>` hacer `await` sobre esa tarea daría como resultado un `String`. Veremos un ejemplo de su uso en el siguiente código. Cabe destacar que para que una función pueda usar la keyword `await` es necesario que sea declarada como `async` por eso nuestra función Main es `async` en este caso

```C#
class Program
{
    static async Task Main(string[] args)
    {
        Console.WriteLine("------------- Comienza el desayuno síncrono ----------------");
        await DesayunoSíncrono();
        Console.WriteLine("------------- Comienza el desayuno asíncrono ----------------");
        await DesayunoAsync();
    }

    static async Task PrepararCafe()
    {
        Console.WriteLine("Preparando café...");
        await Task.Delay(5000);
        Console.WriteLine("Café Listo...");

    }
    static async Task HacerTostada()
    {
        Console.WriteLine("Haciendo la Tostada...");
        await Task.Delay(2000);
        Console.WriteLine("Tostada Lista...");

    }
    static void PonerLaMesa()
    {
        Console.WriteLine("Poniendo la mesa...");
    }
    static async Task BeberCafe()
    {
        Console.WriteLine("Bebiendo café...");
        await Task.Delay(3000);
        Console.WriteLine("Café acabado...");

    }

    static async Task ComerTostada()
    {
        Console.WriteLine("Comiendo tostada...");
        await Task.Delay(3000);
        Console.WriteLine("Tostada acabada...");

    }

    static async Task DesayunoAsync()
    {
        var tareaPrepararCafe = PrepararCafe();
        var tareaPrepararTostada = HacerTostada();
        await tareaPrepararCafe;
        await tareaPrepararTostada;
        PonerLaMesa();
        var tareaBeberCafe = BeberCafe();
        var tareaComerTostada = ComerTostada();

        await tareaBeberCafe;
        await tareaComerTostada;
        Console.WriteLine("Fin del desayuno asícrono");
    }

    static async Task DesayunoSíncrono()
    {
        await PrepararCafe();
        await HacerTostada();
        PonerLaMesa();
        await BeberCafe();
        await ComerTostada();

        Console.WriteLine("Fin del desayuno síncrono");
    }
}
```

La función DesayunoSíncrono ejecuta todas las tareas para preparar el desayuno esperando a que la anterior acabe para empezar la siguiente. La función desayuno asíncrono no bloquea las diferentes tareas y las ejecuta de forma concurrente. Como podemos observar el resultado de la ejecución observamos que varias tareas se están ejecutando al mismo tiempo para el desayuno asíncrono. Esto no significa que la tarea asíncrona sea más rápida necesariamente, si se ejecuta el programa un ordenador con un único procesador ambas tareas deberían tardar lo mismo en acabar.
