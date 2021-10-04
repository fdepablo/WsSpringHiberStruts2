# Struts2 - Actions Anotaciones

En este ejemplo vamos a hacer los mismos que vimos en el ejemplo anterior (02_Actions) pero con anotaciones java.

Las anotaciones proporciona la característica de poder crear una aplicación Struts sin necesidad de crear el archivo de configuración struts.xml

## Configuración

Podemos basarnos en el ejemplo 01_Introducción para configurar este ejemplo, pero debemos añadir además la siguiente dependencia a nuestro pom.xml

	<dependency>
	    <groupId>org.apache.struts</groupId>
	    <artifactId>struts2-convention-plugin</artifactId>
	    <version>2.3.37</version>
	</dependency>
	
## Creación de las clases y sus anotaciones

Ahora simplemente debemos anotar nuestras clases con las anotaciones correspondientes

No es necesario dar ninguna indicación al filtro de Struts 2 de en dónde se encuentran las clases anotadas, siempre y cuando nuestras clases esten dentro de un paquete que se llame "struts2" ya que struts escaneara las clases dentro de este paquete para buscar las anotaciones.

Esto ocurre porque el plugin convention usa, como habíamos dicho, una convención de nombres para saber en dónde se encuentra cierto contenido. En el caso de los Actions, el plugin busca todas las clases Action que implementen la interface "Action" o cuyos nombres terminen con la palabra "Action" y que se encuentren en los paquetes específicos. Estos paquetes son encontrados por el plugin convention usando una cierta metodología de búsqueda. Primero, el plugin busca los paquetes cuyos nombres sean "struts", "struts2", "action" o "actions". Cualquier paquete que coincida con estos nombres es considerado el paquete raíz de los Action por el plugin. Después, el plugin busca todas las clases en este paquete, y en sus sub-paquetes y determina si las clases implementan la interface "Action", extienden de la clase "ActionSupport" o su nombre termina con "Action".

En el caso de que quisieramos que struts2 escanee otros paquetes debemos de configurar el filtro de struts de la siguiente manera

	<filter>
	    <filter-name>struts2</filter-name>
	    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	    <init-param>
	        <param-name>struts.convention.action.packages</param-name>
	        <param-value>PAQUETE_DONDE_SE_ENCUENTRAN_NUESTROS_ACTIONS</param-value>
	    </init-param>
	</filter>