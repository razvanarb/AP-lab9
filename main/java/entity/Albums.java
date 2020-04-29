package entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAlbumByName", query = "SELECT alb FROM Albums alb WHERE alb.name = :Name"),
        @NamedQuery(name = "findAlbumByArtist", query = "SELECT alb FROM Albums alb WHERE alb.artistId = :ArtistId")
})
public class Albums {
    private short id;
    private String name;
    private short artistId;
    private Short releaseYear;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "artist_id")
    public short getArtistId() {
        return artistId;
    }

    public void setArtistId(short artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year")
    public Short getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Short releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Albums albums = (Albums) o;

        if (id != albums.id) return false;
        if (artistId != albums.artistId) return false;
        if (name != null ? !name.equals(albums.name) : albums.name != null) return false;
        if (releaseYear != null ? !releaseYear.equals(albums.releaseYear) : albums.releaseYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) artistId;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }
}
