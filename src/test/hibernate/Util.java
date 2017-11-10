package test.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Util {
	
	//XML based configuration
    private static SessionFactory sessionFactory;
     
    private static synchronized SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .configure( "hibernate.cfg.xml" )
            .build();
        	System.out.println("Hibernate serviceRegistry created");
            Metadata metadata = new MetadataSources( serviceRegistry )
            .getMetadataBuilder()
            .build();
            return metadata.getSessionFactoryBuilder().build();

            
      }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) 
        sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
     
  
}
