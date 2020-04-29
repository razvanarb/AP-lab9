package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * PersistenceUtil class that creates an instance of an EntityManagerFactory
 */
public class PersistenceUtil {

    private EntityManagerFactory entityManagerFactory;
    private static PersistenceUtil instance;

    private PersistenceUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public static PersistenceUtil getInstance() {
        if (instance == null) {
            instance = new PersistenceUtil();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}

