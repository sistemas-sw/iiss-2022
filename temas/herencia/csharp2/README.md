# Herencia

Autor : Carlos Loiz Jordán.

# Consejos

Tener extensiones de C++ y csharp si usas vs code para programarlo ya que hace que sea todo mas facil y sencillo.

# Código 1

// Herencia1 hereda implícitamente de la clase Object.
public class Herencia1 {
    // El campo estático IDactual almacena el ID de trabajo de la última Herencia1 que se ha creado.

    private static int IDactual;

    protected int ID { get; set; }
    protected string titulo { get; set; }
    protected string descripcion { get; set; }
    protected TimeSpan trabajo { get; set; }

    // Constructor predeterminado. Si una clase derivada no invoca explícitamente a un constructor de clase base, se llama implícitamente al constructor predeterminado.
    public Herencia1() {
        ID = 0;
        titulo = "titulo";
        descripcion = "descripcion.";
        trabajo = new TimeSpan();
    }

    // Constructor de objetos que tiene tres parámetros.
    public Herencia1(string titulo, string desc, TimeSpan trabajo_) {

        this.ID = GetNextID();
        this.titulo = titulo;
        this.descripcion = desc;
        this.trabajo = trabajo_;
    }

    // Constructor estático para inicializar el miembro estático, IDactual.
    // Este constructor se llama una vez, automáticamente, antes de que se cree cualquier instancia de Herencia1 o Cambio, 
    //o se haga referencia a IDactual.

    static Herencia1() => IDactual = 0;

    // IDactual es un campo estático. Se incrementa cada vez que se obtiene una ID . Se crea la instancia de Herencia1.
    protected int GetNextID() => IDactual++;

    // Method actualizar le permite actualizar el título y la duración del trabajo de un objeto Herencia1 existente.
    public void actualizar(string titulo, TimeSpan trabajo_) {

        this.titulo = titulo;
        this.trabajo = trabajo_;
    }

    // Anulación del método virtual del método ToString que se hereda de System.Object.
    public override string ToString() => $"{this.ID} - {this.titulo}";
}

// Cambio deriva de Herencia1 y agrega una propiedad (IdOriginal) y dos constructores.
public class Cambio : Herencia1 {

    protected int IdOriginal { get; set; }

    // Constructores. Debido a que ninguno de los constructores llama explícitamente a un constructor de clase base,
    // el constructor predeterminado en la clase base se llama implícitamente.
    // La clase base debe contener un constructor predeterminado.

    public Cambio() { }

 
    public Cambio(string titulo, string desc, TimeSpan trabajo_, int originalID) {

        
        // Las siguientes propiedades y el método GetNexID se heredan de Herencia1.

        this.ID = GetNextID();
        this.titulo = titulo;
        this.descripcion = desc;
        this.trabajo = trabajo_;

        // IdOriginal es propio de cambio pero no de herencia 1

        this.IdOriginal = originalID;
    }
}


// En el bloque siguiente se muestra cómo usar las clases base y derivadas:


Herencia1 item = new Herencia1("Prueba 1", "Falla", new TimeSpan(3, 4, 0, 0));

// Cree una instancia de Cambio usando el constructor en la clase derivada que toma cuatro argumentos.

Cambio cambio_ = new Cambio("Cambia la clase base", "Añade mienbros", new TimeSpan(4, 0, 0), 1);

// Usa el método ToString definido en Herencia1.

Console.WriteLine(item.ToString());

// Utilice el método de actualización heredado para cambiar_ el título del Objeto de cambio.

cambio_.actualizar("cambio_ el Diseño de la Clase Base", new TimeSpan(4, 0, 0));

// Cambio hereda la anulación de ToString de Herencia1.

Console.WriteLine(cambio_.ToString());

/* Salida:
    1 - Prueba 1
    2 - cambio_ el Diseño de la Clase Base
*/

# Explicación 

La herencia, junto con la encapsulación y el polimorfismo, es una de las tres características principales de la programación orientada a objetos.

En el ejemplo se muestra cómo Herencia1 reemplaza el método virtual Object.ToString y cómo la clase Cambio hereda la implementación Herencia1 del método. En el primer bloque se definen las clases.

Para este ejemplo en particular la clase Herencia1 tiene sus atributos los cuales tienen sus geters y setters asociados.

Herencia1 tiene el constructor predeterminado, si la clase base no invoca explícitamente a un constructor de clase base, se llama implícitamente al constructor predeterminado.

 Constructor estático para inicializar el miembro estático, IDactual. Este constructor se llama una vez, automáticamente, antes de que se cree cualquier instancia de Herencia1 o Cambio, 
 o se haga referencia a IDactual.

 Metodo actualizar le permite actualizar el título y la duración del trabajo de un objeto Herencia1 existente.

Ahora tras esto voy a explicar la clase que hereda de 'herencia1' para ello tenemos que empezar por los constructores : 

Debido a que ninguno de los constructores llama explícitamente a un constructor de clase base, el constructor predeterminado en la clase base se llama implícitamente.
La clase base debe contener un constructor predeterminado.

Las propiedades que tiene cambio se hereda de 'herencia1' por lo cual se puede acceder a ellos sin problema y obtener el valor que se ha creado en el cosntructor.

El bloque ultimo voy a implementar la forma la cual se puede probar que todo este bien implementado.

- Tenemos que crear un objeto de la clase base.
- Tras esto tenemos que crear una instancia de 'Cambio' su contructor tiene 4 parametros.
- Vamos a usar el el método ToString que esta definido en Herencia1.
- Utilizamos el método de actualización heredado para cambiar_ el título del Objeto de cambio.
- Cambio hereda la anulación de ToString de Herencia1.

- En el programa anteriormente citado vamos a obtener una salida la cual es  : 

/* Salida:
    1 - Prueba 1
    2 - cambio_ el Diseño de la Clase Base
*/


# Código 2

public class Personal {
    private int _id;
    private string _nombre;

    public int id {
        get { return _id;}
        set { id_ = value;}
    }
    
    public string nombre {
        get { return _nombre;}
        set { _nombre = value;}
    }

    //Constructor para la herencia
    public personal( int id,  string nombre){
        _id = id;
        _nombre = nombre;
    }
}

//Clase que hereda de la base
class Profesor : Personal{

    public Profesor ( int id , string nombre):base(id , nombre){

    }
}

//Programa principal para el uso de la clase.
class Program {
    static void Main(string[] args){

        Profesor _profesor = new Profesor(1 , " Carlos");

        Console.WriteLine(_profesor.id , _profesor.nombre);
    }
}

# Explicación

En este caso de herencia vamos a usar la clase Personal la cual es la super-clase de profesor, esta define los métodos necesarios para la creación de objetos de tipo Personal .

Para que la herencia se efectue tiene la clase Profesor declarar que hereda de Personal de la forma de ':' la cual es como se declara la herencia en C#, Profesor una vez declarado solo tiene que llamar a su constructor con los parametros necesarios para que la clase hija llame al constructor de la clase base.

Para terminar un pequeño código el cual muestra el uso de la herencia con una salida por pantalla.