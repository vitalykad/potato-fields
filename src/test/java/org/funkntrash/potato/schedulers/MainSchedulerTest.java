package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.models.PhotosEntity;
import org.funkntrash.potato.nasa.entities.Photo;
import org.funkntrash.potato.services.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by funkntrash on 22.05.16.
 */


public class MainSchedulerTest {

    public MainScheduler mainScheduler = new MainScheduler();
    public NasaAPIService nasaAPIService;
    public PhotoService photoService;
    public PhotosEntity photosEntity;

    @BeforeMethod
    public void Before(){

        nasaAPIService = mock(NasaAPIServiceImpl.class);
        photoService = mock(PhotoServiceImpl.class);
        photosEntity = mock(PhotosEntity.class);

        mainScheduler.setNasaAPIServiceImpl(nasaAPIService);
        mainScheduler.setPhotoServiceImpl(photoService);

    }



    @Test
    public void Test(){

        mainScheduler.updateDbFromNasaApi();

        verify(nasaAPIService).getMaxSol();
        verify(nasaAPIService).getPhotoSrc(0);

        verify(photoService).getMaxSolPhoto();

    }

}


