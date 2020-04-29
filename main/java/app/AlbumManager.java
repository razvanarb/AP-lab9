package app;

import entity.Albums;
import entity.Artists;
import repo.AlbumRepository;
import repo.ArtistsRepository;

import java.util.List;

/**
 * AlbumManager class that contains a test for the program.
 */
public class AlbumManager {

    public static void main(String[] args) {


        ArtistsRepository artistRepository = new ArtistsRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        /**
         * Searches:
         * 1. For the Artist with id 2
         * 2. For the Artist with the name "Eminem"
         * 3. For the Album with id 2
         * 4. For the Album with the name "Revival"
         */

        System.out.println(artistRepository.findById((short) 2).getName());

        System.out.println();

        List<Artists> artistiCautati =artistRepository.findByName("Eminem");
        for(Artists artist : artistiCautati) {
            System.out.println(artist.getName());
        }

        System.out.println();

        System.out.println(albumRepository.findById((short) 2).getName());

        System.out.println();

        List<Albums> albumeCautate=albumRepository.findByName("Revival");
        for(Albums album : albumeCautate) {
            System.out.println(album.getName());
        }

    }
}

