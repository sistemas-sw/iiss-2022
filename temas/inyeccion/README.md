
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