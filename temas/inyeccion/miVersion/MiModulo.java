package miVersion;

public class MiModulo extends AbstractModule {
    @Override
    protected void configure() {
       bind(OtraClase.class).to(MiOtraClase.class);
    }
}