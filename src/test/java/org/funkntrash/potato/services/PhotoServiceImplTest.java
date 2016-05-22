package org.funkntrash.potato.services;

import org.funkntrash.potato.domain.PhotoDAO;
import org.funkntrash.potato.domain.PhotoDAOImpl;
import org.funkntrash.potato.domain.PhotoDaoImplMock;
import org.funkntrash.potato.models.PhotosEntity;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by funkntrash on 22.05.16.
 */
public class PhotoServiceImplTest {

    private PhotoServiceImpl photoService = new PhotoServiceImpl();


        @BeforeTest
        public void Before(){

            photoService.setPhotoDAOImpl(new PhotoDaoImplMock());

        }

        @Test
        public void TestaddPhoto(){
            photoService.addPhoto(new PhotosEntity());

        }

        @Test
        public void TestlistPhotos(){

            List<PhotosEntity> photosEntityList = photoService.listPhotos();
            int id = photosEntityList.get(0).getId();
            int sol = photosEntityList.get(0).getSol();
            String url = photosEntityList.get(0).getUrl();
            assertEquals(id,345123);
            assertEquals(sol,123345);
            assertEquals(url,"http://foo.bar");

        }

        @Test
        public void TestgetMaxSolPhoto(){

            PhotosEntity photosEntity = photoService.getMaxSolPhoto();
            int id = photosEntity.getId();
            int sol = photosEntity.getSol();
            String url = photosEntity.getUrl();
            assertEquals(id,345123);
            assertEquals(sol,123345);
            assertEquals(url,"http://foo.bar");

        }

}
