package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate5Utils {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static String fichero;

	public static void setFichero(String f) {
		fichero = f;
	}
	
	//Patron singleton
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder()
						.configure(fichero)
						.build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
				//Podemos dar de alta las anotaciones así en vez de por XML
				//.addAnnotatedClass(es.ejemplo1.anotaciones.Persona.class);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				shutdown();
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
