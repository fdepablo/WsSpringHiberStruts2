# Ejemplo Anotaciones

En este ejemplo vamos a coger de base el ejemplo 03 pero vamos a dar de alta la mayoria de los objetos mediante anotaciones.

Las anotaciones con clases en java que permiten cambiar la funcionalidad del programa en tiempo de ejecuci�n o en tiempo de compilaci�n. Empiezan con "@"

## Desventajas de anotaciones

1. Es que todo cambio que se haga hay que hacerlo sobre codigo, lo que implica volver a generar
los ejecutables, compilar, etc.

2. Mediante anotaciones solo podemos tener un objeto de un tipo dado en la aplicacion, es decir,
que si das de alta un pelicula cono prototype solo podras tener ese objeto en tu aplicacion

3. Mediante anotaciones solo podemos dar de alta objetos cuyas clases tengamos su codigo fuenta

## Ventajas de anotaciones

1. Hace el codigo mas sencillo y m�s rapido de implentar.
2. A diferencia de cuando trabajamos con XML NO hace falta hacer los setters y los getters
de los atributos para inyectar los objetos. Spring inyecta los objetos a traves de un API en java que se llama reflection (metaprogramacion). Este API es con la que se hacen practicamente todos los frameworks java