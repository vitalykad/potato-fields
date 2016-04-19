package org.funkntrash.potato.services;

import org.funkntrash.potato.domain.PhotoDAO;

import org.funkntrash.potato.domain.PhotoDAOImpl;
import org.funkntrash.potato.models.PhotosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */

public class PhotoServiceImpl implements PhotoService{

    private PhotoDAO photoDAO;

    public List<PhotosEntity> listPhotos(){

        return new PhotoDAOImpl().listPhoto();

    }

    public PhotosEntity getMaxSolPhoto(){

        return new PhotoDAOImpl().getMaxSolPhoto();

    }

    public void addPhoto(PhotosEntity photosEntity){

        photoDAO = new PhotoDAOImpl();
        photoDAO.addPhoto(photosEntity);


    }

}
