package org.funkntrash.potato.nasa;

/**
 * Created by funkntrash on 28.04.16.
 */
public class NasaApi {

    private String photos;

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getPhotos() {
        return photos;
    }

    @Override
    public String toString()
    {
        return "UserBean [photos=" + this.photos;
    }

}
