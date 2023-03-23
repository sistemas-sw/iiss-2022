package miVersion;

public class MiClase {
    private OtraClase otraClase;
 
    @Inject
    public MiClase(OtraClase otraClase) {
       this.otraClase = otraClase;
    }
 
    public void metodo() {
       // ...
    }
 }
