# Struts2 - Actions

En este ejemplo vamos a hacer ejemplo básicos de una navegación con Action. Ver el ejemplo "01_Introduccion" para configurar el ejemplo.

## Acciones en Struts2

Las acciones o Actions son clases encargadas de realizar la lógica para servir una petición. Cada URL es mapeada a una acción específica, la cual proporciona la lógica necesaria para servir a cada petición hecha por el usuario.

Estrictamente hablando, las acciones no necesitan implementar una interface o extender de alguna clase base. El único requisito para que una clase sea considerada un Action es que debe tener un método que no reciba argumentos que regrese ya sea un String o un objeto de tipo Result. Por default el nombre de este método debe ser "execute" aunque podemos ponerle el nombre que queramos y posteriormente indicarlo en el archivo de configuración de Struts, mediante el atritubo "method" dentro de la etiqueta "package".

Cuando el resultado es un String (lo cual es lo más común), el Result correspondiente se obtiene de la configuración del Action. Esto se usa para generar una respuesta para el usuario. En otros ejemplos trabajaremos con el objeto result

Los Actions pueden ser objetos java simples (POJOs) que cumplan con el requisito anterior, aunque también pueden implementar la interface "com.opensymphony.xwork2.Action" o extender una clase base que proporciona Struts 2: "com.opensymphony.xwork2.ActionSupport".

La interface Action proporciona un conjunto de constantes con los nombres de los Results más comunes, pero podemos devolver el String que queramos. Esta interface luce de la siguiente forma:

	public interface Action 
	{
	    public static final String SUCCESS = "success";
	    public static final String NONE = "none";
	    public static final String ERROR = "error";
	    public static final String INPUT = "input";
	    public static final String LOGIN = "login";
	    
	    public String execute() throws Exception;
	}
	
La clase "ActionSupport" implementa la interface "Action" y contiene una implementación del método "execute()" que regresa un valor de "SUCCESS". Además proporciona unos cuantos métodos para establecer mensajes, tanto de error como informativos, que pueden ser mostrados al usuario.

Los JSP que reciban información deben de incluir la directiva

	<%@taglib uri="/struts-tags" prefix="s" %>
## Resultados en Struts 2

Después que un Action ha sido procesado se debe enviar la respuesta de regreso al usuario, esto se realiza usando results. Este proceso tiene dos componentes, el tipo del result y el resultado mismo.

El tipo del result indica cómo debe ser tratado el resultado que se le regresará al cliente. Por ejemplo un tipo de Result puede enviar al usuario de vuelta una JSP (lo que haremos más a menudo), otro puede redirigirlo hacia otro URL(Response 300 del protocolo HTTP), motro puede enviarle un flujo de bytes que representa un video o un archivo, etc. De momento usaremos el result por defecto llamado "dispatcher", que redirije a un JSP, y más adelante veremos otros Result.

Un Action puede tener más de un result asociado. Esto nos permitirá enviar al usuario a una vista distinta dependiendo del resultado de la ejecución del Action. Por ejemplo en caso de que todo salga bien, enviaremos al usuario al result "sucess", si algo sale mal lo enviaremos al result "error", o si no tiene permisos lo enviaremos al result "denied". 
