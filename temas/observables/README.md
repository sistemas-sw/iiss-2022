# Observables

## RxCpp

Cpp es una biblioteca C++ que implementa ReactiveX, que permite el procesamiento de eventos asíncronos y flujos de datos en tiempo real. Tiene muchos operadores y funciones que ayudan a procesar y transformar streams de eventos asíncronos y flujos de datos, lo que permite crear aplicaciones que reaccionan en tiempo real a eventos y datos en un estilo declarativo y funcional. Además, proporciona utilidades para la programación concurrente y para el manejo de errores.

## Instalar RxCpp

He entrado en el GitHub: https://github.com/ReactiveX/RxCpp
A continuación he descargado la última release: https://github.com/ReactiveX/RxCpp/releases/tag/v4.1.1

He añadido la carpeta RxCpp-4.1.1 para poder ejecutar el programa. Para que funcione, debo incluir el archivo rx.hpp que está en la carpeta src del proyecto.

```cpp
#include "RxCpp-4.1.1/Rx/v2/src/rxcpp/rx.hpp"
```

## Programa

En este ejemplo, creamos un stream de eventos asíncronos que emite enteros del 1 al 10 utilizando la función range() de RxCpp. Luego usamos el operador filter() para filtrar los valores emitidos en el stream y solo mantener los números pares. A continuación, utilizamos el operador map() para elevar al cuadrado los valores pares emitidos. Finalmente, utilizamos el operador take() para tomar los primeros tres valores emitidos después de los filtros y mapeos.

Una vez que hemos creado nuestro stream transformado, nos suscribimos a él y en la lambda que se ejecuta para cada elemento emitido, imprimimos el valor en la consola. Luego, cancelamos la suscripción para asegurarnos de que el programa finalice.

```cpp
rxcpp::observable<int> stream = rxcpp::observable<>::range(1, 10)
    .filter([](int value) {
        return value % 2 == 0;
    })
    .map([](int value) {
        return value * value;
    })
    .take(3);

auto subscription = stream.subscribe([](int value) {
    std::cout << value << std::endl;
});

subscription.unsubscribe();
```

## Ejecución

Compilo:

```console
g++ -std=c++17 observables.cpp -o observables
```

Y ejecuto:

```console
./observables
```

Salida del programa:

```console
4
16
36
```
