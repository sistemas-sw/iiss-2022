# Programacion asíncrona

La programación asíncrona consiste en que el flujo de ejecución del programa no se bloquea mientras se espera a otras tareas. El programa puede ejecutar otras tareas mientras espera a que se complete ese.

Para ello, se usan hilos. Para manejar el resultado de la tarea asíncrona una vez que ha terminado se usan callbacks, promesas o futuros.

## Programación asíncrona en C++

std::async se usa para invocar una función de forma asíncrona en otro hilo. La función devuelve una instancia de std::future para obtener el resultado de la función asícrona. std::promise se utiliza para proporcionar un valor o una excepción de una tarea en otro hilo y se usa en conjunto con la clase std::future para comunicar el resultado o excepción de una tarea asíncrona a otro hilo.

## Ejemplo de programación asíncrona en C++

Creo dos funciones, una que calcula una suma y otra que imprime que está trabajando. La función working la llamaremos de forma asíncrona.

```cpp
int calculateSum(int a, int b) {
    // hago una funcion que consuma tiempo
    std::this_thread::sleep_for(std::chrono::seconds(5));
    return a+b;
}

std::string working(std::string name) {
    // hago una funcion que consuma tiempo
    std::this_thread::sleep_for(std::chrono::seconds(5));

    return name += " is working";
}
```

Dentro del main, creo un string que pasarle a la función working. Creo un objeto promise llamado resultPromise donde meter el resultado de la funcion working. A continuación asocio un objeto futuro llamado futureResult con ese objeto promise. Llamo a la funcion working de forma asincrona usando async y pasando el objeto promesa y el string como argumento. Llamo a la función working con name como parámetro y meto en resultPromise, que es el objeto promise, el resultado. Hago otra tarea mientras working esta ejecutandose: llamo a la función calculateSum e imprimo el resultado. Espero al resultado de working y lo meto en working result usando futureResult.get(). Finalmente, muestro el resultado por pantalla.

```cpp
int main() {
    std::string name = "thread1";

    std::promise<std::string> resultPromise;
    std::future<std::string> futureResult = resultPromise.get_future();

    std::async(std::launch::async, [&resultPromise, name]()
    {
        std::string result = working(name);
        resultPromise.set_value(result);
    });

    std::cout << "Doing some other work...\n";
    int a = 5, b = 50;
    int sum = calculateSum(a,b);
    std::cout << "The result of the sum " << a << " + " << b << " = " << sum << std::endl;

    std::string workingResult = futureResult.get();

    std::cout << "The result of working is: " << workingResult << std::endl;

    return 0;
}
```

## Ejecución

Para ejecutarlo sin errores uso C++17.
Compilo:

```console
g++ -std=c++17 asincrono.cpp -o asincrono
```

Y ejecuto:

```console
./asincrono
```

La salida del programa es:

```console
Doing some other work...
The result of the sum 5 + 50 = 55
The result of working is: thread1 is working
```
