# Contratos

Autor : Carlos Loiz Jordán.

# Consejos

Tener extensiones de C++ y csharp si usas vs code para programarlo ya que hace que sea todo mas facil y sencillo.

# Código

#define CONTRACTS_FULL

using System;
using System.Diagnostics.Contracts;

// Un IArray es una colección ordenada de objetos
[ContractClass(typeof(IArrayContract))]
public interface IArray{
    // La propiedad Item proporciona métodos para leer y editar entradas en rl array.
    Object this[int index]{
        get;
        set;
    }

    int aux {
        get;
    }

    //  Agrega un elemento a la lista. El valor devuelto es la posición en la que se insertó el nuevo elemento.
    int Add(Object valor);

    // Elimina todos los elementos de la lista
    void Clear();

    //Inserta valor en la matriz en el índice de posición.
    //El índice debe ser no negativo y menor o igual que el número de elementos en la matriz. Si el índice es igual al número
    // de elementos en la matriz, luego el valor se agrega al final.
    void Insert(int index, Object valor);

    // Elimina el item de la posicion del índice
    void RemoveAt(int index);
}

[ContractClassFor(typeof(IArray))]
internal abstract class IArrayContract : IArray{
    int IArray.Add(Object valor)    {
        // Devuelve el índice en el que se insertó un elemento.
        Contract.Ensures(Contract.Result<int>() >= -1);
        Contract.Ensures(Contract.Result<int>() < ((IArray)this).aux);
        return default(int);
    }
    Object IArray.this[int index]{
        //función arriba llamada
        get{
            Contract.Requires(index >= 0);
            Contract.Requires(index < ((IArray)this).aux);
            return default(int);
        }
        set{
            Contract.Requires(index >= 0);
            Contract.Requires(index < ((IArray)this).aux);
        }
    }
    public int aux {
        get {
            Contract.Requires(aux >= 0);
            Contract.Requires(aux <= ((IArray)this).aux);
            return default(int);
        }
    }

    void IArray.Clear() {
        Contract.Ensures(((IArray)this).aux == 0);
    }

    void IArray.Insert(int index, Object valor){
        Contract.Requires(index >= 0);
        //La añadimos directamente al final
        Contract.Requires(index <= ((IArray)this).aux);
        Contract.Ensures(((IArray)this).aux == Contract.OldValue(((IArray)this).aux) + 1);
    }

    void IArray.RemoveAt(int index){
        Contract.Requires(index >= 0);
        Contract.Requires(index < ((IArray)this).aux);
        Contract.Ensures(((IArray)this).aux == Contract.OldValue(((IArray)this).aux) - 1);
    }
}

# Explicación 

Los contratos nos proporcionan una manera de especificar condiciones previas, condiciones posteriores e invariantes de un objeto a lo largo de nuestro código.
Las condiciones previas (precondiciones) son requisitos que deben de cumplirse al escribir un método. 
Las condiciones posteriores (postcondiciones) describen las espectativas en el momento en el que se cierra el código del método.
Las invariantes describen el estado esperado de una clase que esta en buen estado.

Además de todo lo anterior los contratos de código incluyen clases para marcar el propio código, un analizador estático para el analis en tiempo de compilación y un analizador en tiempo de ejecución.

Estos van a hacer que los que usen nuestro código desde fuera sea algo mas sencillo y usable y sepan como deben de usarlo.

Para las precondiciones vamos a usar el método Contract.Requires el cual nos permite expresar condiciones previas.
Estas condiciones especifican el estado cuando se invoca un método.
Generalmente se usan para especificar valores de parámetro válidos. Todos los miembros que se mencionan en las condiciones previas deben ser al menos tan accesibles como el propio método, de lo contrario, es posible que la condición previa no sea válida para todos los usuarios de un método concreto. La condición no debe tener efectos secundarios. El analizador de tiempo de ejecucion determina el comportamiento en tiempo de ejecución de las condiciones previas con errores.

En nuestro ejemplo lo usamos por ejemplo : 

Contract.Requires(aux >= 0); El cual nos esta diciendo que el aux tiene que ser mayor o igual que 0 y si no se cumple no se va a ejecutar la precondicion.

Las condiciones posteriores son contratos para el estado de un método cuando finaliza. La condición posterior se comprueba justo antes de salir de un método. El analizador de tiempo de ejecucion determina el comportamiento en tiempo de ejecución de las condiciones posteriores
con errores.

A diferencia de las condiciones previas, las condiciones posteriores pueden hacer referencia a miembros con menos visibilidad. Es posible que algún cliente no sea capaz de entender o usar parte de la información expresada por una condición posterior mediante el estado privado, pero esto no afecta a la capacidad del cliente para usar el método correctamente.

Se usa con el método Contract.Ensures:

En nuestro ejemplo : 
 
Contract.Ensures(((IArray)this).aux == 0);

El cual a la hora de borrado de string nos confirma que se ha borrado con exito.


Instrucciones de uso de los contratos : 

Vamos a nombrar una serie de pasos a la hora de escribir un contrato.

- Requires : Todas las condiciones previas públicas.
- Ensures : Todas las condiciones posteriores públicas (normales).
- Ensures : Todas las condiciones posteriores privadas/internas (normales).
- EndContractBlock : Si usa condiciones previas de estilo if-then-throw sin ningún otro contrato, coloque una llamada a EndContractBlock para indicar que todas las comprobaciones if anteriores son requisitos previos.