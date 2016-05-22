package org.funkntrash.potato.domain;

import org.funkntrash.potato.models.PhotosEntity;

import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */


public interface PhotoDAO {


    public List<PhotosEntity> listPhoto();

    public void addPhoto(PhotosEntity photosEntity);

    public PhotosEntity getMaxSolPhoto();

}
