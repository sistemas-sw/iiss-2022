
using System;

public class circulo
{
        private double radio;

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
            get { return radio; }
            set { radio = value; }
        }
}


namespace Application
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double radio = 5.0;
            circulo c = new circulo(radio);

            Console.WriteLine("El área del círculo es: {0}", c.Area());
            Console.WriteLine("El perímetro del círculo es: {0}", c.Perimetro());
        }
    } 
}