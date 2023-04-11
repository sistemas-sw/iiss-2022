#include <iostream>
#include <vector>
#include <algorithm>

// g++ -std=c++17 lambdas.cpp -o lambdas

int main() {

    // sin captura
    auto lambdaSinCaptura = []() {
        std::cout << "¡Hola desde una lambda sin captura!" << std::endl;
    };
    lambdaSinCaptura();

    // captura por valor
    int x = 10;
    auto lambdaCapturaValor = [x]() {
        std::cout << "¡Hola desde una lambda con captura por valor! x = " << x << std::endl;
    };
    lambdaCapturaValor();

    // captura por referencia
    x = 10;
    auto lambdaCapturaReferencia = [&x]() {
        std::cout << "¡Hola desde una lambda con captura por referencia! x = " << x << std::endl;
        x = 20; // Modificación de la variable capturada por referencia
    };
    lambdaCapturaReferencia(); // Ejecución de la función lambda
    std::cout << "x después de ejecutar la lambda: " << x << std::endl; // Imprime 20

    // captura por referencia constante
    x = 10;
    auto lambdaCapturaReferenciaConstante = [&x]() {
        std::cout << "¡Hola desde una lambda con captura por referencia constante! x = " << x << std::endl;
        // x = 20; // Error de compilación, no se puede modificar una referencia constante
    };
    lambdaCapturaReferenciaConstante();

    // captura por movimiento
    std::vector<int> vec = {1, 2, 3};
    auto lambdaCapturaMovimiento = [vec = std::move(vec)]() mutable {
        std::cout << "¡Hola desde una lambda con captura por movimiento!" << std::endl;
        vec.push_back(4); // Modificación del vector capturado por movimiento
    };
    lambdaCapturaMovimiento();
    std::cout << "Tamaño del vector después de ejecutar la lambda: " << vec.size() << std::endl; // Imprime 3


    // mutable
    x = 10;
    auto lambdaMutable = [x]() mutable {
        std::cout << "¡Hola desde una lambda mutable! x = " << x << std::endl;
        x = 20; // Modificación de la variable capturada por valor
    };
    lambdaMutable(); // Ejecución de la función lambda
    std::cout << "x después de ejecutar la lambda: " << x << std::endl; // Imprime 10

    // genérica
    auto lambda_generic = [](auto x, auto y) { return x + y; };
    std::cout << "Resultado de lambda genérica: " << lambda_generic(3, 5) << std::endl;

    // variádica
    auto lambda_variadic = [](auto... args) { return (args + ...); };
    std::cout << "Resultado de lambda variádica: " << lambda_variadic(1, 2, 3, 4, 5) << std::endl;
    
    return 0;
}
