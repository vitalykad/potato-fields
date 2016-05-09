package org.funkntrash.potato.models;

import javax.persistence.*;

/**
 * Created by Home on 17.04.2016.
 */
@Entity
@Table(name = "photos", schema = "potato_fields", catalog = "")
public class PhotosEntity {
    private int id;
    private String url;
    private Integer sol;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 256)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "sol", nullable = true)
    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotosEntity that = (PhotosEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (sol != null ? !sol.equals(that.sol) : that.sol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (sol != null ? sol.hashCode() : 0);
        return result;
    }
}
