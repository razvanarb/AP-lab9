package repo;

import entity.Artists;
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * ArtistRepository class which contains the methods that interact with the database regarding artists.
 */
public class ArtistsRepository {

    private EntityManagerFactory factory;
    private EntityManager eM;

    public ArtistsRepository() {
        factory = PersistenceUtil.getInstance().getEntityManagerFactory();
        eM = factory.createEntityManager();
    }

    /**
     * Saves an artist entity into the database
     */

    public void create(Artists artist) {
        eM.getTransaction().begin();
        eM.persist(artist);
        eM.getTransaction().commit();
    }

    /**
     * Returns an artist based on it's id
     */
    public Artists findById(Short id) {
        eM.getTransaction().begin();
        Artists artist = eM.find(Artists.class, id);
        eM.getTransaction().commit();
        return artist;
    }

    /**
     * Returns an artist based on it's name
     */
    public List<Artists> findByName(String name) {
        eM.getTransaction().begin();
        List artists = eM.createNamedQuery("findArtistByName").setParameter("Name", name).getResultList();
        eM.getTransaction().commit();
        return artists;
    }
}

