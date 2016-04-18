package org.funkntrash.potato.services;

/**
 * Created by funkntrash on 18.04.16.
 */
import org.funkntrash.potato.models.PhotosEntity;
import java.util.List;

public interface PhotoService {

    public void addPhoto(PhotosEntity photosEntity);

    public List<PhotosEntity> listPhotos();

    public void removePhotos(Integer id);
}

