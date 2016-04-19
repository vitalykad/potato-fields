package org.funkntrash.potato.services;

import java.util.List;
import org.funkntrash.potato.models.PhotosEntity;

public interface PhotoService {

    public List<PhotosEntity> listPhotos();

    public void addPhoto(PhotosEntity photosEntity);

    public PhotosEntity getMaxSolPhoto();

}