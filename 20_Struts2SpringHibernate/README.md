# Struts2 - Proyecto Struts2 + Spring + Hibernate

Podemos mezclar todas las tecnologías que hemos aprendido en un solo proyecto. En este proyecto vamos a seguir el patron MVC.

Normalmente utilizaremos Struts2 para implementar la parte Controladora, y Spring + Hibernate para la parte del Modelo. Para las vistas utilizaremos JSPs.
	
## Configuración

Podemos basarnos en el ejemplo 01_Introduccion para su configuración. Esta parte sería para configurar un proyecto base en struts en el que meteremos el resto de librerías.

Lo siguiente que vamos a hacer es añadir a nuestra app las librerias de Spring e hibernate , para ello tenemos que meter las liberías en pom.xml. 

	<!-- Metemos las liberias base de spring -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.2.5.RELEASE</version>
		</dependency>
		
		<!-- Metemos las librerias de spring para proyecto web
			Esto lo hacemos ya que nostros no podemos dar de alta 
			el contexto de spring de manera manual, y tenemos que
			decirle a Tomcat que a partir de estas liberias de de
			alta el contexto de spring (applicationContext)
		 -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-web</artifactId>
		    <version>5.2.5.RELEASE</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/org.apache.struts/struts2-spring-plugin -->
		<!-- Estas librerás son para que puedan relacionarse las librerias de 
			struts con las de spring y puedan trabajar juntos si que den de alta
			varios objetos del mismo tipo en la app (Controladora y action)
		 -->
		<dependency>
			<groupId>org.apache.struts</groupId>
			<artifactId>struts2-spring-plugin</artifactId>
			<version>2.3.37</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<!-- Librerias de hibernate -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.31.Final</version>
		</dependency>
		
		<!-- Como vamos a usar spring para dar de alta hibernate y ademas para que
		nos gestione las transaccionalidades, debemos de usar unas librerias
		especificas de spring para ello -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-orm</artifactId>
		    <version>5.2.5.RELEASE</version>
		</dependency>
		
		<!-- Estas librerias se usan para que tomcat nos gestione el pull
		de conexines a la BBDD -->
		<dependency>
		    <groupId>org.apache.tomcat</groupId>
		    <artifactId>tomcat-dbcp</artifactId>
		    <version>9.0.1</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<!-- El motor de bbdd que usemos, en este caso MySql version 8 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.26</version>
		</dependency>

## Configuracion Spring

El siguiente paso es decirle a Tomcat que cuando arranque la app en el servidor, arranque el contexto de Spring. Para ello debemos de añadir el siguiente listener al web.xml

	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

Los listener son escuchador (eventos) los cuales cuando ocurre alguna circuntacia en el contexto de tomcat, reaccionan a dicho evento.

Este listener basicamente arranca el contexto de spring a partir de un fichero xml que lo va a ir a buscar a la carpeta de WEB-INF. Dicho fichero se tiene que llamar "applicationContext.xml". Todo esto es configurable y podemos cambiar rutas, el nombre del fichero, etc.

## Configuracion Hibernate

Hibernate va a ser gestionado por Spring, por lo tanto podemos configurarlo y darlo de alta de dos maneras

1. Mediante XML
2. Mediante Anotaciones

Para este ejemplo vamos a utilizar Anotaciones. Creamos la clase es.struts2.cfg.HibernateConf.java

Una vez creada la clase, creamos la entidad empleado en es.struts2.modelo.entidad

El ultimo paso seria crear el esquema de bbdd en la bbdd, que seria "struts2"

Desplegamos la app en el tomcat y cruzamos los dedos :). Debería de arrancar la app.

## Crear la app basandose en MVC

1. Crear la persistencia con el Dao.
2. Crear el negocio
3. Crear los controladores (Actions)
4. Crear las vistas

	
## Visualizacion del ejemplo

1. probar mediante login.jsp que nos podemos registrar, si ha ido bien, nos lleva a la pagina segura
2. probar que a la pagina segura solo podemos acceder mediante el login o mediante SeguroAction
3. Probar pruebaExceptionInterceptor.jsp para mostrar la pagina de errores

## Bibliografia
https://struts.apache.org/
https://docs.spring.io/spring-framework/docs/current/reference/html/
https://hibernate.org/orm/documentation/5.5/

Criterias: https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm

