#  Lambdas

Una función lambda o expresión lambda, es una forma de definir una función anónima en un lenguaje de programación. Permite crear una función en línea sin necesidad de declararla previamente con un nombre.

Son muy útiles cuando se necesitan funciones simples y pequeñas que se puedan utilizar localmente en un bloque de código, como argumentos de función o en asignaciones de variables. Además, pueden capturar variables del entorno y ser pasadas como argumentos a otras funciones.

Estructura:

```scss
[Capturas] (Parámetros) -> TipoRetorno {
    // Cuerpo de la función
}
```

+ Capturas: Son variables que se pueden capturar del entorno. Pueden ser por valor, por referencia o por movimiento, según el lenguaje.
+ Parámetros: Son los parámetros de la función lambda, separados por coma.
+ TipoRetorno: Es el tipo de dato que devuelve la función lambda. Puede ser implícito o explícito, según el lenguaje de programación.

## Lambdas en C++

Hay varios tipos de funciones lambda, según su capacidad de captura de variables y por los tipos de parámetros y valores de retorno que aceptan.

### Lambda sin captura

Son funciones lambda que no capturan ninguna variable del entorno en el que se definen. Tienen la siguiente sintaxis:

```cpp
[]() {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>

int main() {
    auto lambda = []() {
        std::cout << "¡Hola desde una lambda sin captura!" << std::endl;
    };
    lambda(); // Ejecución de la función lambda
    return 0;
}
```

### Lambda con captura por valor

Son funciones lambda que capturan variables del entorno por valor, lo que significa que obtienen una copia de la variable en el momento de la definición de la lambda. Tienen la siguiente sintaxis:

```cpp
[valor1, valor2]() {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto lambda = [x]() {
        std::cout << "¡Hola desde una lambda con captura por valor! x = " << x << std::endl;
    };
    lambda(); // Ejecución de la función lambda
    return 0;
}
```

### Lambda con captura por referencia

Son funciones lambda que capturan variables del entorno por referencia, lo que significa que obtienen una referencia a la variable original en el entorno en el momento de la definición de la lambda. Tienen la siguiente sintaxis:

```cpp
[&referencia1, &referencia2]() {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto lambda = [&x]() {
        std::cout << "¡Hola desde una lambda con captura por referencia! x = " << x << std::endl;
        x = 20; // Modificación de la variable capturada por referencia
    };
    lambda(); // Ejecución de la función lambda
    std::cout << "x después de ejecutar la lambda: " << x << std::endl; // Imprime 20
    return 0;
}
```

### Lambda con captura por referencia constante

Son funciones lambda que capturan variables del entorno por referencia constante, lo que significa que obtienen una referencia constante a la variable original en el entorno en el momento de la definición de la lambda. Tienen la siguiente sintaxis:

```cpp
[&referencia_const1, &referencia_const2]() {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto lambda = [&x]() {
        std::cout << "¡Hola desde una lambda con captura por referencia constante! x = " << x << std::endl;
        // x = 20; // Error de compilación, no se puede modificar una referencia constante
    };
    lambda(); // Ejecución de la función lambda
    return 0;
}
```

### Lambda con captura por movimiento

Son funciones lambda que capturan variables del entorno por movimiento, lo que significa que obtienen la propiedad de la variable original en el entorno en el momento de la definición de la lambda. Tienen la siguiente sintaxis:

```cpp
[valor_movido1, valor_movido2]() {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>
#include <vector>

int main() {
    std::vector<int> vec = {1, 2, 3};
    auto lambda = [vec = std::move(vec)]() mutable {
        std::cout << "¡Hola desde una lambda con captura por movimiento!" << std::endl;
        vec.push_back(4); // Modificación del vector capturado por movimiento
    };
    lambda(); // Ejecución de la función lambda
    std::cout << "Tamaño del vector después de ejecutar la lambda: " << vec.size() << std::endl; // Imprime 3
    return 0;
}
```

### Lambda mutable

Son funciones lambda que permiten modificar las variables capturadas por valor, aunque la función lambda sea constante. Se utiliza la palabra clave "mutable" para indicar que se permite la modificación de las variables capturadas por valor. Tienen la siguiente sintaxis:

```cpp
[valor1, valor2]() mutable {
    // Cuerpo de la función lambda
}
```

```cpp
#include <iostream>

int main() {
    int x = 10;
    auto lambda = [x]() mutable {
        std::cout << "¡Hola desde una lambda mutable! x = " << x << std::endl;
        x = 20; // Modificación de la variable capturada por valor
    };
    lambda(); // Ejecución de la función lambda
    std::cout << "x después de ejecutar la lambda: " << x << std::endl; // Imprime 10
    return 0;
}
```

###  Lambda genérica

La función lambda que no especifica ningún tipo de dato en particular se considera genérica. En este ejemplo, se define una función lambda genérica que toma dos parámetros enteros (x e y) y devuelve la suma de ellos. Puedes llamar a esta función lambda pasando dos argumentos enteros y obteniendo la suma de ellos.

```scss
auto lambda_generic = [](auto parametro1, auto parametro2, ...) {
    // Cuerpo de la lambda
};
```

```cpp
auto lambda_generic = [](int x, int y) { return x + y; };
std::cout << "Resultado de lambda genérica: " << lambda_generic(3, 5) << std::endl;
```

### Lambda variádica

Una función lambda variádica en C++ es una función anónima que puede aceptar un número variable de argumentos de diferentes tipos. Esto se logra utilizando la sintaxis auto... en la lista de parámetros de la función lambda, lo que permite que la función lambda acepte un número variable de argumentos, y luego usar el operador de desplegado ... para expandir y procesar los argumentos dentro del cuerpo de la lambda. Tienen la siguiente sintaxis:

```scss
auto lambda_variadic = [](auto... args) {
    // Cuerpo de la lambda
};
```

```cpp
auto lambda_variadic = [](auto... args) { return (args + ...); };
std::cout << "Resultado de lambda variádica: " << lambda_variadic(1, 2, 3, 4, 5) << std::endl;
```

Donde args es el nombre que se le da a los argumentos variables de la función lambda. Estos argumentos pueden ser utilizados dentro del cuerpo de la lambda para llevar a cabo alguna operación o cálculo.

En este ejemplo, se define una función lambda variádica que toma un número variable de argumentos de cualquier tipo (args) y devuelve la suma de todos ellos. La función lambda utiliza el operador de desplegado ... para expandir los argumentos y sumarlos. Esta es una característica disponible en C++14 y versiones posteriores.

## Ejecución

Como estamos usando versiones de C++ posteriores a C++14, así que por si acaso voy a compilar con la opción -std=c++17.

Compilación:

```console
g++ -std=c++17 lambdas.cpp -o lambdas
````

Ejecución:

```console
./lambdas
```

Salida del programa:

```console
¡Hola desde una lambda sin captura!
¡Hola desde una lambda con captura por valor! x = 10
¡Hola desde una lambda con captura por referencia! x = 10
x después de ejecutar la lambda: 20
¡Hola desde una lambda con captura por referencia constante! x = 10
¡Hola desde una lambda con captura por movimiento!
Tamaño del vector después de ejecutar la lambda: 0
¡Hola desde una lambda mutable! x = 10
x después de ejecutar la lambda: 10
Resultado de lambda genérica: 8
Resultado de lambda variádica: 15
```
