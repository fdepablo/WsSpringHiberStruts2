# Struts2 - Interceptores

Struts 2 integra un mecanismo que nos permite abstraer funcionalidades comunes a todos los actions de una manera sencilla, aplicarlas de forma transparente a dichas acciones que la necesiten (que pueden ser desde una hasta todas las acciones de la aplicación) y configurarlas a través del uso de parámetros.

Estas funcionalidades puedes ser de diversa naturaleza como controlar sesiones, restringir acceso a páginas, escritura de logs...

Para realizar esta funcionalidad struts utiliza los llamados interceptores, que pueden realizar funcionalidades cruzadas. Esto sería equivalente los filtros en JEE o la programación orientada a aspectos.

Los interceptores realizan tareas antes y después de la ejecución de un Action y también pueden evitar que un Action se ejecute (por ejemplo si estamos haciendo alguna validación que no se ha cumplido). Sirven para ejecutar algún proceso particular que se quiere aplicar a un conjunto de Actions. De hecho muchas de las características con que cuenta Struts 2 son proporcionadas por los interceptores.

Si alguna funcionalidad que necesitamos no se encuentra en los interceptores de Struts 2, podemos crear nuestro propio interceptor y agregarlo a la cadena o pila que se ejecuta por default. 

De la misma forma, podemos modificar la pila de interceptores de Struts 2, por ejemplo para quitar un interceptor o modificar su orden de ejecución.

Struts por defecto nos proporciona 1 pila basica con interceptores, aplicando los interceptores en el orden en el que se encuentran. Esta pila es conocida como <b>defaultStack</b> y siempre se aplicará a no ser que se modifique o se quiera implementar otra. Los interceptores que encontraremos serán los siguientes:

1. exception
2. alias
3. servletConfig
4. prepare
5. i18n
6. chain
7. debugging
8. profiling
9. scopedModelDriven
10. modelDriven
11. fileUpload
12. checkbox
13. staticParams
14. conversionError
15. validation
16. workflow

Para incluir interceptores en nuestros actions mediante XML pondremos la etiqueta

	<interceptor-ref name="NOMBRE_DEL_INTERCEPTOR"/>
	
El orden de las etiquetas marcara el orden de la pila. Por supuesto tambien podemos poner una pila, por ejemplo si ponemos:

	<interceptor-ref name="inteceptor1"/>
	<interceptor-ref name="defaultStack"/>
	
Se añadira el "interceptor1" al principio de la pila por defecto, si lo ponemos al final, el interceptor se añadira al final y se ejecutará despues de todos los interceptores por defecto.

Hay más interceptores creados en Struts2, como pueden ser:

	<interceptor-ref name="timer" />
	<interceptor-ref name="logger" />

El primero tomara los tiempos de ejecución, el segundo mostrara trazas cuando se invoque

Para crear nuestros propios interceptores en java, tendremos que crear una clase que implemente la interfaz <b>com.opensymphony.xwork2.interceptor.Interceptor</b> y luego darla de alta en el fichero XML mediante la etiqueta:

	<interceptor name="NOMBRE_INTERCEPTOR" 	class="CLASE_INTERCEPTOR" />
	
## Configuración

Podemos basarnos en el ejemplo 01_Introduccion para su configuración. Este ejemplo lo haremos con archivo de configuracion

	
## Visualizacion del ejemplo

1. probar mediante login.jsp que nos podemos registrar, si ha ido bien, nos lleva a la pagina segura
2. probar que a la pagina segura solo podemos acceder mediante el login o mediante SeguroAction
3. Probar pruebaExceptionInterceptor.jsp para mostrar la pagina de errores
