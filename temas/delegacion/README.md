
# Delegación en ruby

Cuando usamos delegación un objeto transfiere la responsabilidad de realizar una tarea a otro objeto. En lugar de realizar directamente la tarea en sí mismo, el objeto delega la tarea a otro objeto que es capaz de realizarla de manera más eficiente o especializada.

A diferencia de la herencia, evita la dependencia directa de otras clases.


## proc

Es un objeto que representa un bloque de código que puede ser almacenado en una variable o pasarse como argumento a un método. Los Proc se pueden ejecutar varias veces y pueden tomar argumentos.

```Ruby
sumar = Proc.new { |a, b| a + b }
puts sumar.call(1, 2)
```

## module

Es una forma de agrupar métodos relacionados y constantes en un espacio de nombres. Los módulos se utilizan a menudo para crear mezclas (mixins) que se pueden incluir en otras clases.

```Ruby
module Greeting
  def say_hello
    puts "Hello!"
  end
end

class Person
  include Greeting
end

person = Person.new
person.say_hello
```

## delegate

Es un patrón de diseño que permite que un objeto delegue algunas responsabilidades a otro objeto. Se usa el módulo Forwardable.

```ruby
require 'forwardable'

class Car
  extend Forwardable

  def initialize(driver)
    @driver = driver
  end
  
  def_delegator :@driver, :drive
end

class Driver
  def drive
    puts "I'm driving the car!"
  end
end

driver = Driver.new
car = Car.new(driver)
car.drive # Output: "I'm driving the car!"
```