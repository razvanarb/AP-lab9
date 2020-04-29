package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Charts {
    private short id;
    private short idAlbum;
    private Short rank;
    private Short idChart;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_album")
    public short getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(short idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Basic
    @Column(name = "rank")
    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "id_chart")
    public Short getIdChart() {
        return idChart;
    }

    public void setIdChart(Short idChart) {
        this.idChart = idChart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charts charts = (Charts) o;

        if (id != charts.id) return false;
        if (idAlbum != charts.idAlbum) return false;
        if (rank != null ? !rank.equals(charts.rank) : charts.rank != null) return false;
        if (idChart != null ? !idChart.equals(charts.idChart) : charts.idChart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (int) idAlbum;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (idChart != null ? idChart.hashCode() : 0);
        return result;
    }
}
