package repo;

import entity.Albums;
import entity.Artists;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


/**
 * AlbumRepository class which contains the methods that interact with the database regarding albums.
 */
public class AlbumRepository {

    private EntityManagerFactory factory;
    private EntityManager eM;

    public AlbumRepository() {
        factory = PersistenceUtil.getInstance().getEntityManagerFactory();
        eM = factory.createEntityManager();
    }

    /**
     * Saves an album entity into the database
     */
    public void create(Albums album) {
        eM.getTransaction().begin();
        eM.persist(album);
        eM.getTransaction().commit();
    }

    /**
     * Returns an album based on it's id
     */
    public Albums findById(Short id) {
        eM.getTransaction().begin();
        Albums album = eM.find(Albums.class, id);
        eM.getTransaction().commit();
        return album;
    }

    /**
     * Returns one or more albums based on a name query
     */

    public List<Albums> findByName(String name) {
        eM.getTransaction().begin();
        List albums = eM.createNamedQuery("findAlbumByName").setParameter("Name", name).getResultList();
        eM.getTransaction().commit();
        return albums;
    }


    /**
     * Returns one or more albums based on a artist query
     */
    public List<Albums> findByArtist(Artists artist) {
        eM.getTransaction().begin();
        List albums = eM.createNamedQuery("findAlbumByArtist").setParameter("ArtistId", artist.getId()).getResultList();
        eM.getTransaction().commit();
        return albums;
    }
}

