// g++ -std=c++17 observables.cpp -o observables
// ./observables

#include <iostream>
#include <string>
#include "RxCpp-4.1.1/Rx/v2/src/rxcpp/rx.hpp"

int main()
{
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

    return 0;
}
