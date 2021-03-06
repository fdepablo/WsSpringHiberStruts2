Configuracion de un proyecto Maven en Eclipse
-

Maven es una herramienta de software para la gesti?n y construcci?n de proyectos Java. Nos ayuda
a gestionar el ciclo de vida de una aplicaci?n java

Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros m?dulos y componentes externos, y el orden de construcci?n de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilaci?n del c?digo y su empaquetado. 

Para realizar un proyecto maven en eclipse:

1) File -> new -> Maven proyect

2) Checkear la opcion "Create a simple proyect", para hacerlo de la manera m?s sencilla

3) En la pantalla que nos sale de configuraci?n de proyecto debemos dar el nombre del grupo
del proyecto y nombre del artefacto:
	
	3.1) Nombre del grupo, ser?a la agrupaci?n del proyecto, muchos proyectos tienen un mismo grupo.
	Podriamos entenderlo como el nombre de la compa?ia que ha hecho el proyecto. Tiene formato de
	paquete en java.
	Ej: com.empresa.departamente
		com.felix
		es.felix
		es.dgt.puntos
		
	3.2) Nombre del artefacto, ser?a el propio nombre del proyecto
	Ej: NombreProyecto
		Minecraft
		WhatsApp
		30_Maven
		
La conbinaci?n de nombre del grupo junto con el nombre del proyecto, deber?a de ser UNICA en el mundo

3) Un proyecto Maven tiene una estructura de carpetas y paquetes establecida por defecto, esto es para
que todos los proyectos maven del mundo sean lo m?s parecidos posibles.
Entre las carpetas y paquetes m?s importantes encontraermos:

	3.1) src/main/java, esta carpeta es donde pondremos todos nuestros ficheros fuente del proyecto.
	Es de las carpetas m?s importantes
	
	3.2) src/main/resources, en esta carpeta pondremos todos los ficheros que son recursos de nuestra
	aplicacion. Por ejemplo un fichero .txt que sera leido, un fichero .dat que servira para guardar
	objetos de nuestra aplicacion, un fichero .properties, un fichero de configuraci?n, etc.
	
	3.3) src/test/java, igual que la carpeta 3.1 pero para realzar las pruebas de nuestra aplicaci?n
	
	3.4) src/test/resources, igual que la carpeta 3.2 pero para realzar las pruebas de nuestra aplicaci?n
	
	3.5) Maven dependecies, aqui podemos ver todos las librer?as (.jar) que van a ser usadas en nuestro
	proyecto. Se configuran en el fichero pom.xml
	
	3.6) target, principalmente podremos encontrar los ejecutables de nuestro proyecto
	
	3.7) src, donde estan los fuentes finales del proyecto
	
	3.8) pom.xml, es el fichero m?s importante de un proyecto MAVEN. Es donde controlaremos el ciclo
	de vida de nuestro proyecto, desde con que version de java trabajaremos, que librer?as queremos
	usar, hasta como queremos generar el ejecutable o desplegable de nuestro proyecto. Este fichero
	es donde tenemos que ir para configurar todo nuestro proyecto.
	
4) Una vez configurado el fichero pom.xml, podemos empezar a realizar nuestro proyecto, normalmente
en src/main/java. Para este ejemplo hemos usado la libreria de pdf que hemos a?adido a nuestras
dependencias. Ver el fichero pom.xml para ver m?s detalles de donfiguraci?n.

5) Si cambiamos la jdk de java, tenemos que hacer un maven -> update proyect
	
## Spring

Un framework java (super framework). Basicamente es un framework que trabaja con 
POJOs (Plain old java objet). Son objetos sencillos que siguen el convenio 
Javabean, es decir no tienen porque tener herencias, interfaces, etc.

En spring hay dos conceptos claves, 

1. IoC, Inversion de control -> Este principio nos dice que el programador no tiene el control total sobre el ciclo de vida de los objetos. Podemos crear aplicaciones java sin necesidad de hacer "news". Los programadores se van a encargar de programar los objetos y decir al contexto de spring cual ser?a su ciclo de vida.

2. ID, inyeccion de dependencias -> Los objetos en una aplicaci?n no suelen trabajar solos, sino que dependen de otros objetos para realizar una funcion. Mediante Spring podemos inyectar objetos a otros objetos de manera automatica y sencilla.

Por otra parte, en Spring podemos trabajar tanto con ficheros XML como con anotaciones para dar de alta todos los objetos y hacer sus dependencias. Aunque se pueden utilizar las dos, es cierto que con anotaciones es mas estandar.

Es recomendable cuando trabajamos con spring en eclipse utilizar algun plugin que nos ayude a configurar las aplicaciones de manera mas comoda. Help -> Eclipse Marketplace -> buscar por la palabra Spring y bajarnos el plugin Spring tools 4.12g

En este ejemplo vamos a utilizar Spring mediante fichero XML, que tenemos que crear en src/main/resources	
Bibliografia
-
https://maven.apache.org/
