# Resolver el problema de los valores undefined y el mal uso de null

Para resolver el problema de los valores undefined y el mal uso de null en C++ se puede utilizar la clase std::optional que permite representar un valor que puede o no estar presente. La clase std::optional se encuentra en la librería estándar de C++ a partir de la versión C++17.

He definido las clases ScreenResolution, DisplayFeatures y Mobile con los mismos campos que en el ejemplo original, pero utilizando std::optional para aquellos campos que pueden no estar presentes.

## ScreenResolution

Esta es la clase ScreenResolution.java original. No usa optional de Java.

```java
public class ScreenResolution {
  private int width;
  private int height;

  public ScreenResolution(int width, int height){
    this.width = width;
    this.height = height;
  }
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }
}
```

Esta es la version C++ usando std::optional. Como podemos observar, en el constructor los parámetros que
recibimos son de tipo entero, pero usamos std::optional<int> para indicar que son int y además opcionales. En la parte privada además los almacenamos igual, y debemos tenerlo en cuenta en los métodos observadores. Esto es porque el tipo de la variable es std::optional<int>.

```c++
class ScreenResolution {
    public:
        ScreenResolution(std::optional<int> w, std::optional<int> h) : width(w), height(h) {}

        std::optional<int> getWidth() const { return width; }
        std::optional<int> getHeight() const { return height; }
    private:
        std::optional<int> width;
        std::optional<int> height;
};
```

Hago lo mismo con DisplayFeatures y Mobile.

# MobileService

En la clase MobileService compruebo si son nulas o no con has_value(), y si alguna es nula devuelvo un cero, si no, devuelvo el ancho por el alto.

```c++
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
```

## main

Aquí pruebo si el código funciona correctamente. Creo un móvil, primero sin atributos nulos y después con atributos nulos; en el primer caso me devuelve el dato calculado, y en el segundo me devuelve cero.

```c++
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
```

## Ejecución del programa

Compilar. Uso -std=c++17 porque std::optional se añadió en C++17, así evito que compile con una versión anterior de C++.

```console
clang++ -std=c++17 MobileTester.cpp -o MobileTester
```

Ejecutar:

```console
./MobileTester
```

Salida del programa:

```console
Apple iPhone 6s Screen Width = 1000500
Apple iPhone 16s Screen Width = 0
```
