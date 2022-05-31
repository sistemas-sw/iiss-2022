using System;
using System.Collections.Generic;

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
      aux.addString(".");
      
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
//    Salida : 
//
//    iniConsonante tiene 0 elegate.
//    iniVocal tiene 0 elegate.
//
//    iniConsonante y iniVocal estan derivados del multicastDelegate.
//
//    Ejecutando...

//    Un
//    para
//    delegate
//
//    Ejecutando...
//    ejemplo
//    mas
//    .
//
//    multipleDelegates tiene  elegates.
//
//    Ejecutando... delegate.
//    Un
//    ejemplo
//    mas
//    para
//    delegate
//    .
//
//    Ejecutando... delegate con dos iniConsonante delegates:
//    Un
//    Un
//    para
//    para
//    delegate
//    delegate