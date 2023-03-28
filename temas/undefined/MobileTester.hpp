#ifndef MOBILETESTER
#define MOBILETESTER

#include <optional>
#include <string>

class ScreenResolution {
    public:
        ScreenResolution(std::optional<int> w, std::optional<int> h) : width(w), height(h) {}

        std::optional<int> getWidth() const { return width; }
        std::optional<int> getHeight() const { return height; }
    private:
        std::optional<int> width;
        std::optional<int> height;
};

class DisplayFeatures {
    public:
        DisplayFeatures(std::optional<std::string> s, ScreenResolution r) : size(s), resolution(r) {}

        std::optional<std::string> getSize() const { return size; }
        ScreenResolution getResolution() const { return resolution; }
    private:
        std::optional<std::string> size;
        ScreenResolution resolution;
};

class Mobile {
    public:
        Mobile(int i, std::string b, std::string m, DisplayFeatures f) : id(i), brand(b), model(m), features(f) {}

        int getId() const { return id; }
        std::string getBrand() const { return brand; }
        std::string getModel() const { return model; }
        DisplayFeatures getFeatures() const { return features; }
    private:
        int id;
        std::string brand;
        std::string model;
        DisplayFeatures features;
};

class MobileService {
    public:
        int getMobileScreenWidth(const Mobile& mobile) {
            int width = 0;
            DisplayFeatures features = mobile.getFeatures();
            ScreenResolution resolution = features.getResolution();

            if (resolution.getWidth().has_value() && resolution.getHeight().has_value()) {
                width = resolution.getWidth().value() * resolution.getHeight().value();
            }

            return width;
        }
};

#endif