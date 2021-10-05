# Struts2 - Results

Cada vez que un Action termina su ejecución, se muestra un resultado al usuario. Estos resultados pueden ser de muchos tipos y tener muchos significados. El tipo más común de resultado es mostrar al usuario una nueva página web cierta información, pero podemos hacer muchas más cosas, como regresar un fichero, redireccionar a otra página web, o encadenar la petición a otro Action para que la procese.

Hay que tener claro que el result que hemos estado utilizando hasta ahora es un objeto, por lo que podremos decidir que tipo de objeto result elegiremos en función de nuestras necesidades.

Cada result tiene un nombre que debe ser único para un Action y es en base a este nombre que Struts 2 sabrá qué es lo que debe mostrarle al usuario. La interface "Action", que es implementada por la clase "ActionSupport", que hemos estado utilizando como base para nuestros Actions, proporciona un conjunto de constantes que contienen los nombres de los results más comunes para que podamos usarlos dentro de nuestros Actions.

1. <b>"success"</b> - Indica que todo ha salido correctamente (validaciones, y el proceso de lógica en general) durante la ejecución del método, por lo que el usuario puede ver la salida esperada.
2. <b>"error"</b> - Indica que alguna cosa dentro del método ha salido mal. Puede ser que algún cálculo no pueda realizarse, o que algún servicio externo que estemos utilizando no esté disponible en ese momento o se haya lanzado alguna excepción.
3. <b>"input"</b> - Indica que algún campo proporcionado en un formulario es incorrecto. Puede ser que el valor no sea del tipo esperado, o no cumpla con el formato o rango requerido.
4. <b>"login"</b> - Indica que el recurso al que el usuario está intentado acceder solo está disponible para usuarios registrados del sitio y por lo tanto debe loguearse primero. Para poder usar este result de forma correcta debemos crear un result global en la configuración del sitio.
5. <b>"none"</b> - Este es un result de un tipo especial ya que le indica a Struts 2 que no debe enviar al usuario a ningún lugar especial (o en términos formales que el procesamiento del resultado sea cancelado). 

Un Action puede tener más de un result y estos pueden ser de distintos tipos, uno para cada situación que necesite manejar (como hemos visto hasta ahora).

Los result más importantes dentro de una app de Strut 2 son los siguientes:

1. <b>"dispatcher"</b> - Este es el result más usado y el default. Envía como resultado una nueva vista, usalmente una jsp.
2. <b>"redirect"</b> - Le indica al navegador que debe redirigirse a una nueva página, que puede estar en nuestra misma aplicación o en algún sitio externo, y por lo tanto este creará una nueva petición para ese recurso.
3. <b>"redirectAction"</b> - Redirige la petición a otro Action de nuestra aplicación. En este caso se crea una nueva petición hacia el nuevo Action.
4. <b>"chain"</b> - Al terminarse la ejecución del Action se invoca otro Action. En este caso se usa la misma petición para el segundo Action, el cual se ejecuta de forma completa, con todo su stack de interceptores y sus results (podemos crear cadenas de cuantos Actions queramos).
5. <b>"stream"</b> - Permite enviar un archivo binario de vuelta al usuario.
6. <b>"plaintext"</b> - Envía el contenido del recurso que indiquemos como un texto plano. Típicamente se usa cuando necesitamos mostrar una JSP o HTML sin procesar
7. <b>"httpheader"</b> - Permite establecer el valor de la cabecera HTTP de código de estatus que se regresará al cliente. Así por ejemplo podemos usarlo para enviar un error al cliente (estatus 500), un recurso no encontrado (404), un recurso al que no tiene acceso (401), o por el que requiere pagar (402).

## Configuración

Podemos basarnos en el ejemplo 01_Introduccion para su configuración. Este ejemplo lo haremos con archivo de configuracion
	
## Visualización

1. Ejemplo dispatcher, entramos desde la URL mapeada en el fichero struts.xml
2. Ejemplo redirect, entramos desde la URL mapeada en el fichero struts.xml
3. Ejemplo redirect action, entramos desde el enlace del fichero index.jsp
4. Ejemplo chain, entramos desde el enlace del fichero index.jsp
