package es.struts2.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Con esta anotacion decimos a spring que dentro va a haber beans que queremos
//dar de alta
@Configuration
//Con esta anotacion le decimos a spring que queremos que sea el ( en vez de hibernate)
//el que nos gestine las transacciones
@EnableTransactionManagement
public class HibernateConf {

	//Damos de alta el objeto SessionFactory en el contexto de spring
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        //Configurar el dataSource
        sessionFactory.setDataSource(dataSource());
        //Le decimos al sessionFactory donde tiene que ir a buscar
        //anotaciones de hibernate/jpa
        sessionFactory.setPackagesToScan("es.struts2.modelo.entidad");
        //Configuramos las propiedades de spring (create-drop, muestre sql...) 
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //Driver de conexion
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //Localizacion de la bbdd y el protocolo
        dataSource.setUrl("jdbc:mysql://localhost:3306/struts2");
        dataSource.setUsername("root");//user
        dataSource.setPassword("");//pass

        return dataSource;
    }

    //El objeto que nos va a llevar las transacciones con spring
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        //Le indicamos el session factory que vamos a utilizar
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    //Las propiedades particulares de hibernate, que no damos de alta
    //directamente en el contexto
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty(
                "hibernate.show_sql", "true");

        return hibernateProperties;
    }
    
    /*
     * try (InputStream url = Configuracion.class.getClassLoader()
				.getResourceAsStream("config.properties");){
			// Cargamos el properties
			// tiene que estar dentro de una ruta de classpath
			properties = new Properties();
			properties.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
     */
}