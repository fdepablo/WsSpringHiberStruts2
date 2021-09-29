# JPQL
JPQL es un lenguaje intermedio entre POO y SQL, usado por principalmente por JPA para hacer consultas a la BBDD

Las consultas tienen el siguiente formato:

	SELECT atributos FROM ClaseEntidad Alias 
		WHERE criterio
		GROUP BY atributos
		HAVING criterio
		ORDER BY atributos
		
Aunque suele usarse principalmente para consultas, tambien podriamos hacer updates, deletes o inserciones, pero para eso es mucho más comun usar los metodos estandar de JPA o de Hibernate.

## Bibliografía
1. https://docs.oracle.com/html/E13946_04/ejb3_langref.html
2. https://www.tutorialspoint.com/es/jpa/jpa_jpql.htm

