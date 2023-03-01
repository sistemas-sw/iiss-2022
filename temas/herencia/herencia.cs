
using System;

public class PersonajeDeAccion {
    public virtual void Luchar() {}
}

public class Heroe : PersonajeDeAccion {
    public override void Luchar() {}
    public void Volar() {}
}

public class Creador {
    public PersonajeDeAccion[] Personajes() {
        PersonajeDeAccion[] x = {
            new PersonajeDeAccion(),
            new PersonajeDeAccion(),
            new Heroe(),
            new PersonajeDeAccion()
        };
        return x;
    }
}

public class Aventura {
    public static void Main(string[] args) {
        PersonajeDeAccion[] cuatroFantasticos = new Creador().Personajes();
        cuatroFantasticos[1].Luchar();
        cuatroFantasticos[2].Luchar(); // Upcast

        // En tiempo de compilacion: metodo no encontrado:
        //! cuatroFantasticos[2].Volar();
        ((Heroe)cuatroFantasticos[2]).Volar(); // Downcast
        try {
            ((Heroe)cuatroFantasticos[1]).Volar(); // InvalidCastException
        }
        catch (InvalidCastException e) {
            Console.WriteLine("Error: {0}", e.Message);
        }
        foreach (PersonajeDeAccion p in cuatroFantasticos) {
            p.Luchar();
        }
        foreach (PersonajeDeAccion p in cuatroFantasticos) {
            try {
                ((Heroe)p).Volar(); // InvalidCastException for elements 0, 1, and 3
            }
            catch (InvalidCastException e) {
                Console.WriteLine("Error: {0}", e.Message);
            }
        }
    }
}
