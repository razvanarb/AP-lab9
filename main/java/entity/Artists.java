package entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findArtistByName", query = "SELECT artist FROM Artists artist WHERE artist.name = :Name")
public class Artists {
    private short id;
    private String name;
    private String country;

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
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artists artists = (Artists) o;

        if (id != artists.id) return false;
        if (name != null ? !name.equals(artists.name) : artists.name != null) return false;
        if (country != null ? !country.equals(artists.country) : artists.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
