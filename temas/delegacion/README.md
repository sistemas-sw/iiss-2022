
# Delegación en Ruby

Cuando usamos delegación un objeto transfiere la responsabilidad de realizar una tarea a otro objeto. En lugar de realizar directamente la tarea en sí mismo, el objeto delega la tarea a otro objeto que es capaz de realizarla de manera más eficiente o especializada.

A diferencia de la herencia, evita la dependencia directa de otras clases.

## Orquesta

En este ejemplo, tenemos una clase Orquesta que es un conjunto de instrumentos, que son de la clase Instrumento. Ambas clases usan Enumerable, que es un módulo en Ruby que proporciona métodos que se pueden utilizar para hacer que una clase sea iterable. Esto es el equivalente al Iterable de Java que se usa en la clase Orquesta original.

```ruby
class Orquesta
    include Enumerable
    # ...
end
    
class Instrumentos
    include Enumerable
    # ...
end
```

## Cómo ejecutar

Hay que instalar Ruby. En mac se instala:

```console
brew install ruby
````

A continuación se compila y ejecuta con el siguiente comando:

```console
ruby archivo.rb
````


## Particularidades de Ruby

Al ejecutar inicialmente aparecían errores con nil, que es es un objeto que representa la ausencia de valor o la falta de un objeto y se utiliza para indicar que una variable o una expresión no tienen ningún valor o que no han sido inicializadas. Se usa para representar el resultado de una operación que no ha tenido éxito o que ha producido un resultado vacío.

Por ello, hay que comprobar siempre si un objeto es nil.

```ruby
def tocar
        @instrumentos.each { |i| i.tocar unless i.nil? }
      end
```

