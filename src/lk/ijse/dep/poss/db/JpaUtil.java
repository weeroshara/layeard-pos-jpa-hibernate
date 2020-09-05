package lk.ijse.dep.poss.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JpaUtil {

    private static EntityManagerFactory ent= buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        File file=new File("resource/application.properties");

        Properties jpaProp=new Properties();
        try {
            jpaProp.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Persistence.createEntityManagerFactory("DEP",jpaProp);

    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return ent;
    }

}
