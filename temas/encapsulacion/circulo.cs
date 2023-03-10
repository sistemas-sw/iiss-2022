
using System;

public class circulo
{
        private double radio;
        private String nombre;

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

        public double Radio
        {
            get { return radio; init; }
        }
        
        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
}


namespace Application
{
    public class Program
    {
        public static void Main(string[] args)
        {
            circulo c = new circulo {radio = 5.0};
       
            c.nombre = "circulo1";
            

            Console.WriteLine("El área del círculo es: {0}", c.Area());
            Console.WriteLine("El perímetro del círculo es: {0}", c.Perimetro());
        }
    } 
}
