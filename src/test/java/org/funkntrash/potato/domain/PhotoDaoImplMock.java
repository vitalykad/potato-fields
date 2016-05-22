package org.funkntrash.potato.domain;

import org.funkntrash.potato.models.PhotosEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by funkntrash on 22.05.16.
 */
public class PhotoDaoImplMock implements PhotoDAO {

    public PhotosEntity photosEntity;

    public PhotoDaoImplMock(){
        this.photosEntity = new PhotosEntity();
        this.photosEntity.setId(345123);
        this.photosEntity.setSol(123345);
        this.photosEntity.setUrl("http://foo.bar");
    }

    public List<PhotosEntity> listPhoto() {
        List<PhotosEntity> photosEntityList = new ArrayList<PhotosEntity>();

        photosEntityList.add(this.photosEntity);

        return photosEntityList;
    }

    public void addPhoto(PhotosEntity photosEntity) {

    }

    public PhotosEntity getMaxSolPhoto() {

        return this.photosEntity;
    }
}
