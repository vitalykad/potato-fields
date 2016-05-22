package org.funkntrash.potato.services;

import org.funkntrash.potato.domain.PhotoDAO;

import org.funkntrash.potato.models.PhotosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoDAO photoDAOImpl;

    public void setPhotoDAOImpl(PhotoDAO photoDAOImpl) {
        this.photoDAOImpl = photoDAOImpl;
    }

    public List<PhotosEntity> listPhotos(){

        return photoDAOImpl.listPhoto();

    }

    public PhotosEntity getMaxSolPhoto(){

        return photoDAOImpl.getMaxSolPhoto();

    }

    @Transactional
    public void addPhoto(PhotosEntity photosEntity){

        photoDAOImpl.addPhoto(photosEntity);

    }

}
