# Struts2 - Scopes

Cuando estamos desarrollando una aplicación web debemos almacenar información que será procesada de distinta manera. Dependiendo de cuál sea el propósito de esta información querremos que tenga un tiempo de vida más corto o más largo, alguna información deberá permanecer disponible durante todo el momento que viva nuestra aplicación, mientras que otra solo nos interesará que viva durante una petición o una sesion. 

Estos tiempos de vida son llamados scopes, y en las aplicaciones web tenemos tres principalmente. Es importante conocer estos scopes y ver qué tipo de información es conveniente colocar en cada uno de ellos. Estos scopes trabajan con atributos donde podemos colocar la información que queremos guardar

También algunas veces es necesario tener un acceso directamente a los objetos del API de Servlets, como el "HttpServletRequest", o el "ServletContext", o a los parámetros de la petición,

Las aplicaciones web con Java tienen básicamente tres scopes o tiempos de vida:

1. <b>Application:</b> Es el scope más largo ya que abarca el tiempo de vida completo de la apicación; esto es, los datos vivirán mientras la aplicación esté activa. Este alcance es compartido por todos los usuarios.
2. <b>Session:</b> Este scope nos permite tener datos que vivirán a lo largo de múltiples peticiones HTTP para un mismo usuario, mientras el usuario esté dentro de la aplicación. Cada usuario verá únicamente sus datos y no habrá forma de que vea los de los demás. En java por defecto la session dura 30 minutos y se pasa el token de session del cliente al servidor mediante cookie.
3. <b>Request:</b> Este es el scope más pequeño, los datos asociados con la petición únicamente estarán disponibles mientras se realiza dicha petición.

Struts 2 nos proporciona tres formas para colocar y leer los atributos que se encuentren en estos scopes:

1. Implementación de interfaces Aware (Más común)
2. Uso del objeto "ActionContext"
3. Uso del objeto "ServletActionContext"


## Configuración

Podemos basarnos en el ejemplo 03_Anotaciones para su configuración. Este ejemplo lo haremos con anotaciones.
	

