
# Inyeccion en Java con Guice

## Instalacion

Creo un proyecto en Maven con:

```console
mvn archetype:generate
```

Dentro de pom.xml meto las dependencias:

```xml
<dependency>
    <groupId>com.google.inject</groupId>
    <artifactId>guice</artifactId>
    <version>4.2.3</version>
</dependency>
```

Instalo las dependencias:

```console
cd ./temas/inyeccion
mvn install
```

Busco el .jar:

```console
cd ~/.m2/repository/
find . -name "*guice*.jar" -exec sh -c "unzip -l '{}' | grep -q 'guice'" \; -print
./org/sonatype/sisu/sisu-guice/2.1.7/sisu-guice-2.1.7-noaop.jar
```

Ejecuto:

```console
cd ./1-backend/src/main/java/1
javac -cp ./org/sonatype/sisu/sisu-guice/2.1.7/sisu-guice-2.1.7-noaop.jar main.java
```

Fin

>>>>>>> c8bb6efde7a8c7ce262b18710e6ebcbc25a99c54



Para inyectar una dependencia a una clase usando Guice, primero necesitas crear un módulo de Guice. Este módulo es responsable de configurar las dependencias y definir cómo se deben inyectar en las clases. Para hacerlo, sigue los siguientes pasos:

Crea una clase que extienda AbstractModule, que es una clase de Guice. Esta clase debe ser capaz de proporcionar todas las dependencias que se necesitan.
Sobrescribe el método configure() en esta clase. Este método es el punto de entrada para definir todas las dependencias.
Dentro del método configure(), usa el método bind() para asociar una implementación de una interfaz o clase abstracta con una implementación concreta. Por ejemplo, para asociar la interfaz MyInterface con la clase MyImplementation, se puede usar el siguiente código:
scss
Copy code
bind(MyInterface.class).to(MyImplementation.class);
Si la clase a la que se quiere inyectar una dependencia es una clase externa, se puede usar la anotación @Inject en su constructor para indicar que se deben inyectar ciertas dependencias. Por ejemplo:
kotlin
Copy code
public class MyClass {
  private final MyDependency myDependency;
  
  @Inject
  public MyClass(MyDependency myDependency) {
    this.myDependency = myDependency;
  }
}
Finalmente, crea una instancia de Injector, que es una clase de Guice que se encarga de crear y proporcionar todas las dependencias. Para hacerlo, puedes usar el siguiente código:
vbnet
Copy code
Injector injector = Guice.createInjector(new MyModule());
MyClass myClass = injector.getInstance(MyClass.class);
En este ejemplo, MyModule es la clase que defines para configurar todas las dependencias, y MyClass es la clase que quieres inyectar con dependencias. El método getInstance() del Injector se encarga de crear una instancia de la clase MyClass con todas las dependencias inyectadas.