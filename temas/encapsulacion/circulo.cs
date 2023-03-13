
using System;
using System.Runtime.CompilerServices;

namespace System.Runtime.CompilerServices
{
    public static class IsExternalInit {}
}

public class circulo
{
        public double radio {get; init;}
        public String nombre;

        public circulo(double radio)
        {
            this.radio = radio;
        }

        public double Area()
        {
            return Math.PI * radio * radio;
        }

        public double Perimetro()
        {
            return 2 * Math.PI * radio;
        }
        
        public String Nombre
        {
            get { return nombre; }
            set
            {
                if (value != "circulo")
                    nombre = value;
                else
                    throw new Exception("Error, usa un nombre mas significativo");
            }
        }
}


namespace Application
{
    public class Program
    {
        public static void Main(string[] args)
        {
            circulo c = new circulo(5.0);
       
            c.nombre = "circulo1";

            try
        {
            c.Nombre = "circulo";
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message); // Imprime "Error, usa un nombre más significativo"
        }
            
            Console.WriteLine("El nombre del circulo es: {0}", c.Nombre);
            Console.WriteLine("El área del círculo es: {0}", c.Area());
            Console.WriteLine("El perímetro del círculo es: {0}", c.Perimetro());
        }
    } 
}
