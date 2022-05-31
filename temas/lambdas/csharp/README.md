# Lambdas

Autor : Carlos Loiz Jordán.

# Consejos

Tener extensiones de C++ y csharp si usas vs code para programarlo ya que hace que sea todo mas facil y sencillo.

# Código

using System;
public class ejeploDelegate  {

   // Declara un delegado para un método que recibe un int y devuelve una cadena.
   public delegate string delegate( int aux );


   public class delegateClass  {


      public string mostrarString ( int aux )  {
         if ( aux > 0 ) return( "positivo" );
         if ( aux < 0 ) return( "negativo" );
         return ( "no consta" );
      }

 
      public static string mostarOperacion ( int aux )  {
         if ( aux > 0 ) return( "+" );
         if ( aux < 0 ) return( "-" );
         return ( "" );
      }
   }

   public static void Main()  {

      // Crea un delegate para cada método
      delegateClass dgClass = new delegateClass();
      delegate var = new delegate( dgClass.mostrarString );
      delegate var2 = new delegate( delegateClass.mostarOperacion );

      Console.WriteLine( 5, var( 5 ), var2( 5 ) );
      Console.WriteLine( -3, var( -3 ), var2( -3 ) );
      Console.WriteLine( 0, var( 0 ), var2( 0 ) );
   }
}

# Explicación 

Un delegate es un tipo que representa referencias a métodos con una lista de parámetros determinada y un tipo de valor devuelto. Cuando se crea una instancia de delegate , puede asociar su instancia a cualquier método mediante una signatura compatible y un tipo de valor devuelto. Puede invocar (o llamar) al método a través de la instancia del delegado.

En el ejemplo siguiente se muestra cómo definir un delegado denominado delegate
 . Las instancias de este delegado se crean para un método de instancia y un método estático de la clase anidada delegateCalss . El delegate para el método de instancia requiere una instancia de delegateClass. La delegateClass instancia se guarda una variable denominada dgClass.

# MultiCast delegate

class Coleccion {
   public delegate void EjecutaDelegate(string str);

   private List<String> aux = new List<String>();

   public void addString(string str) {
      aux.Add(str);
   }

   public void Show(EjecutaDelegate show_)  {
      foreach (var str in aux) {
         show_(str);
      }
   }
 }
class Cadena {
   public static void iniConsonante(string str) {
      if (!(str[0]=='a'||str[0]=='e'||str[0]=='i'||str[0]=='o'||str[0]=='u'))
          Console.WriteLine(str);
   }

   public static void iniVocal(string str)  {
      if ((str[0]=='a'||str[0]=='e'||str[0]=='i'||str[0]=='o'||str[0]=='u'))
          Console.WriteLine(str);
   }
}
class Test {
   static public void Main() {

      Coleccion aux = new Coleccion();
      aux.addString("Un");
      aux.addString("ejemplo");
      aux.addString("mas");
      aux.addString("para");
      aux.addString("delegate");
      aux.addString(".")
      
      Coleccion.EjecutaDelegate iniConsonante = Cadena.iniConsonante;
      Coleccion.EjecutaDelegate iniVocal = Cadena.iniVocal;

      Delegate[] listaDelegate = iniConsonante.GetInvocationList();
      Console.WriteLine("iniConsonante tiene 0 delegate.", listaDelegate.Length);
      listaDelegate = iniVocal.GetInvocationList();
      Console.WriteLine("iniVocal tiene 0 delegate.\n", listaDelegate.Length);

      if (iniConsonante is System.MulticastDelegate && iniVocal is System.MulticastDelegate)
          Console.WriteLine("iniConsonante y iniVocal estan derivados del multicastDelegate.\n");

      Console.WriteLine("Ejecutando...");
      aux.Show(iniConsonante);
      Console.WriteLine();
      Console.WriteLine("Ejecutando...");
      aux.Show(iniVocal);
      Console.WriteLine();

      Coleccion.EjecutaDelegate multipleDelegates = (Coleccion.EjecutaDelegate) Delegate.Combine(iniConsonante, iniVocal);

      listaDelegate = multipleDelegates.GetInvocationList();
      Console.WriteLine("\n MultipleDelegates tiene 0 delegates.\n", listaDelegate.Length);

      Console.WriteLine("Ejecutando... delegate.");
      aux.Show(multipleDelegates);

      multipleDelegates = (Coleccion.EjecutaDelegate) Delegate.Remove(multipleDelegates, iniVocal);
      multipleDelegates = (Coleccion.EjecutaDelegate) Delegate.Combine(multipleDelegates, iniConsonante);

      Console.WriteLine("\nEjecutando... delegate con dos iniConsonante delegates:");
      aux.Show(multipleDelegates);
   }
}

# Explicación 

En el método siguiente vamos a definir una clase , Coleccion la cual incluye una coleccion de cadenas en su interior.
Uno de los miembros es EjecutaDelegate el cual se usa para mostrar las cadenas en Coleccion.

En el método se define una clase : Cadena : la cual tiene dos métodos delegados : 'iniConsonante' y 'iniVocal'

iniConsonante :  muestra las cadenas que comienzan con un consonante.
iniVocal : muestra las cadenas que comienzan con una vocal.

Hay que tener en cuenta que ambos métodos incluyen un único parametro de cadena y devuelven void. Ambos métodos se pueden asignar al EjecutableDelegate.

Test es la clase por la que accedemos al Main , se crea una instancia de Coleccion , lo rellena con cadenas ( las cuales estan de mero ejemplo )  y crea dos EjecutableDelegate , ' iniConsonante' y 'iniVocal' , uque ambos invocan a un único método.
Despues se llama a Delegate.Combine que es el método mas importante ya que crea los multiples delegates, muestra todas las cadenas de la colección en su orden original. Esto se debe a que cada letra se pasa por separado a cada delegate y cada letra cumple los criterios de filtrado de solo uno de los dos delegates. 

Por último, déspues de las llamadas a Delegate.Remove y Delegate.Combine, multipleDelegates contiene dos iniConsonantes y cuando se invica, cada cadena de Coleccion se muestra dos veces.