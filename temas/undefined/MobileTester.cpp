#include <iostream>
#include <optional>
#include <string>

#include "MobileTester.hpp"


int main() {
    ScreenResolution resolution{750, 1334};
    DisplayFeatures dfeatures{"4.7", resolution};
    Mobile mobile{2015001, "Apple", "iPhone 6s", dfeatures};

    MobileService mService;

    std::optional<int> mobileWidth = mService.getMobileScreenWidth(mobile);
    if (mobileWidth.has_value()) {
        std::cout << "Apple iPhone 6s Screen Width = " << mobileWidth.value() << std::endl;
    } else {
        std::cout << "Failed to get screen width for Apple iPhone 6s" << std::endl;
    }

    ScreenResolution resolution2{0, 0};
    DisplayFeatures dfeatures2{"0", resolution2};
    Mobile mobile2{2015001, "Apple", "iPhone 6s", dfeatures2};

    std::optional<int> mobileWidth2 = mService.getMobileScreenWidth(mobile2);
    if (mobileWidth2.has_value()) {
        std::cout << "Apple iPhone 16s Screen Width = " << mobileWidth2.value() << std::endl;
    } else {
        std::cout << "Failed to get screen width for Apple iPhone 16s" << std::endl;
    }

    return 0;
}