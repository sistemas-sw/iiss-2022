using System;

namespace Application
{

    public class Circulo
    {
            public double Radio {get; init;}
            public String Nombre;

            public Circulo(double Radio)
            {
                this.Radio = Radio;
            }

            public double ObtenerArea()
            {
                return Math.PI * Radio * Radio;
            }

            public double ObtenerPerimetro()
            {
                return 2 * Math.PI * Radio;
            }

            public String ObtenerNombre
            {
                get { return Nombre; }
                set
                {
                    if (value != "circulo")
                        Nombre = value;
                    else
                        throw new Exception("Error, usa un nombre mas significativo");
                }
            }
    }

    public class Program
    {
        public static void Main(string[] args)
        {
            circulo c = new circulo(5.0);
       
            c.Nombre = "circulo1";

            try {
                c.Nombre = "circulo";
            } catch (Exception e) { Console.WriteLine(e.Message); } // Imprime "Error, usa un nombre más significativo"
            
            Console.WriteLine("El nombre del circulo es: {0}", c.ObtenerNombre);
            Console.WriteLine("El área del círculo es: {0}", c.ObtenerArea());
            Console.WriteLine("El perímetro del círculo es: {0}", c.ObtenerPerimetro());
        }
    }
}
