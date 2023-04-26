// g++ -std=c++17 asincrono.cpp -o asincrono
// ./asincrono

#include <iostream>
#include <string>
#include <future>
#include <chrono>

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

int main() {
    std::string name = "thread1";

    // creo un objeto promise donde meter el resultado de la funcion working
    std::promise<std::string> resultPromise;

    // asocio un objeto futuro con un objeto promise
    std::future<std::string> futureResult = resultPromise.get_future();

    // llamo a la funcion working de forma asincrona usando async y pasando el objeto promesa y el string como argumento
    std::async(std::launch::async, [&resultPromise, name]()
    {
        // calculo la funcion
        std::string result = working(name);

        // meto el resultado en la promesa
        resultPromise.set_value(result);
    });

    // hago otra tarea mientras working esta ejecutandose
    std::cout << "Doing some other work...\n";
    int a = 5, b = 50;
    int sum = calculateSum(a,b);
    std::cout << "The result of the sum " << a << " + " << b << " = " << sum << std::endl;

    // espero al resultado de working
    std::string workingResult = futureResult.get();

    // imprimo el resultado
    std::cout << "The result of working is: " << workingResult << std::endl;

    return 0;
}
