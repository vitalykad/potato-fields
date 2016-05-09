package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.models.PhotosEntity;

import org.funkntrash.potato.nasa.entities.NasaAPI;
import org.funkntrash.potato.services.NasaAPIService;
import org.funkntrash.potato.services.PhotoService;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by funkntrash on 18.04.16.
 */

public class MainScheduler {

    @Autowired
    NasaAPIService nasaAPIService;

    @Autowired
    private PhotoService photoServiceImpl;

    private int current_sol = 0;

    private static final String ANGRY_BATKO_IMG="http://image.zn.ua/media/images/original/Jan2015/107798.jpg";
    //Для тестового режим
    @Scheduled(fixedRate = 10000)
    //В боевом режиме
    //@Scheduled(fixedRate = 88775245)
    private void clearTempFolder() {

        PhotosEntity photosEntity = photoServiceImpl.getMaxSolPhoto();

        if (photosEntity != null){

            if (current_sol == 0) {
                current_sol = photosEntity.getSol() + 1;
            } else {
                current_sol++;
            }

        }
        else {

            //В боевом режиме выбираем последний сол

            //current_sol = nasaAPIService.getMaxSol();

            //На время тестирования используем предпоследний сол

            current_sol = nasaAPIService.getMaxSol()- 1;

        }

        String img_src = nasaAPIService.getPhotoSrc(current_sol);

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
