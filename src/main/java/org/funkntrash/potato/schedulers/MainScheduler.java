package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.models.PhotosEntity;

import org.funkntrash.potato.services.NasaAPIService;
import org.funkntrash.potato.services.NasaAPIServiceImpl;
import org.funkntrash.potato.services.PhotoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * Created by funkntrash on 18.04.16.
 */

public class MainScheduler {

    @Autowired
    NasaAPIService nasaAPIServiceImpl;

    @Autowired
    private PhotoService photoServiceImpl;

    private int current_sol = 0;
    private final long solInMilliseconds=88775245;

    private String ANGRY_BATKO_IMG="";

    @Value("#{urls.ANGRY_BATKO_IMG}")
    public void setANGRY_BATKO_IMG(String ANGRY_BATKO_IMG) {
        this.ANGRY_BATKO_IMG = ANGRY_BATKO_IMG;
    }

    public void setNasaAPIServiceImpl(NasaAPIService nasaAPIServiceImpl) {
        this.nasaAPIServiceImpl = nasaAPIServiceImpl;
    }

    public void setPhotoServiceImpl(PhotoService photoServiceImpl) {
        this.photoServiceImpl = photoServiceImpl;
    }


    @Scheduled(fixedRate = solInMilliseconds)
    protected void updateDbFromNasaApi() {

        PhotosEntity photosEntity = photoServiceImpl.getMaxSolPhoto();

        if (photosEntity != null){

            if (current_sol == 0) {
                current_sol = photosEntity.getSol() + 1;
            } else {
                current_sol++;
            }

        }
        else {

            current_sol = nasaAPIServiceImpl.getMaxSol();

        }

        String img_src = nasaAPIServiceImpl.getPhotoSrc(current_sol);

        PhotosEntity photo = new PhotosEntity();
        photo.setSol(current_sol);

        if (img_src != ""){

            photo.setUrl(img_src);

        }
        else {
            photo.setUrl(ANGRY_BATKO_IMG);
        }

        photoServiceImpl.addPhoto(photo);

    }


}
