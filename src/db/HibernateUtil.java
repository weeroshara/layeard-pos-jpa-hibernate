package db;

import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSesionFatory();

    private static SessionFactory buildSesionFatory(){


        File file = new File("resource/application.properties");

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .configure( "org/hibernate/example/hibernate.cfg.xml" )
                .loadProperties(file)
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
//                .addAnnotatedClass( MyEntity.class )
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class)


                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();

        return sessionFactory;

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
