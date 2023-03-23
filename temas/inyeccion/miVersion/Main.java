package miVersion;

public class Main()
{
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MiModulo());
        MiClase miClase = injector.getInstance(MiClase.class);
        miClase.metodo();
    }
}


