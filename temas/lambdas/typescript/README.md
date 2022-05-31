# Bloque 4: Funcionalidad y Asíncrono

## Requisitos
> Debemos tener previamente instalado [NodeJS](https://nodejs.org/en/) y TypeScript `npm install -g typescript`

## Compilar
`tsc lambda.ts`
## Ejecutar
`node lambda.js`

## Lambdas en TypeScript
TypeScript usa las "arrow functions" que tiene una equivalencia directa con 
las funciones lambda.

Las funciones lambda son funciones de una sola instrucción (normalmente) que se almacenan en una variable, o que se ejecutan directamente. Se caracterizan de que NO hace falta escribir return, porque se sobre entiende que la función devuelve algo.
Aunque se podrian poner los return y funcionaria perfectamente.

Las funciones lambdas pueden tener más de una instrucción, para ello debemos de englobar el contenido con ```{}``` y obligatorio usar `return` .
### Tipos

> Arrow function sin parametros
>
> Arrow function con un solo parametro
>
> Arrow function con multiples parametros tipados
>
> Arrow function con arrays tipados como parametros
>
> Arrow function con un numero indefinido de parametros sin tipado (Pueden ser de cualquier tipo)
>
> Arrow function con valores de retorno

Se muestran la gran variedad de propiedades que tienen las funciones lambda en
TypeScript como lo son las mostradas

**Formato basico**
```TYPESCRIPT
// Cabecera
const arrowFunction = () => console.log('aqui mi instruccion');

const arrowFunction = () => { 
    // varias instruccions
}
```

El scope que tienen permite acceder a varibales de ambito superior (Diferencia principal con JAVA).
Una funcion lambda en JAVA tiene el scope fijo, y no puede modificar variables, solo tratar con objetos y con
variables marcadas de tipo `final`, en typescript tenemos libertad total.