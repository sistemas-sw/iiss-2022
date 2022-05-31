
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

    // IDactual es un campo estático. Se incrementa cada vez que se obtiene una ID. Se crea la instancia de Herencia1.
    protected int GetNextID() => IDactual++;

    // Metodo actualizar le permite actualizar el título y la duración del trabajo de un objeto Herencia1 existente.
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

// Utiliza el método de actualización heredado para cambiar_ el título del Objeto de cambio.

cambio_.actualizar("cambio_ el Diseño de la Clase Base", new TimeSpan(4, 0, 0));

// Cambio hereda la anulación de ToString de Herencia1.

Console.WriteLine(cambio_.ToString());

/* Salida:
    1 - Prueba 1
    2 - cambio_ el Diseño de la Clase Base
*/