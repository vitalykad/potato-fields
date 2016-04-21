package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.models.PhotosEntity;

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

    private static int current_sol = 0;
    private static final String ANGRY_BATKO_IMG="http://image.zn.ua/media/images/original/Jan2015/107798.jpg";
    private static final String NO_PHOTO_WARN="Отсутствует фото за сол %d";
    private static final String API_URL="https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS";

    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PhotoService photoServiceImpl;

    private JSONObject getFirstPhotoJSON(String jsonString){

        JSONObject json = new JSONObject(jsonString);
        JSONArray photosArray = (JSONArray) json.get("photos");

        return (JSONObject) photosArray.get(0);
    }

    private int getMaxSolFromNASA(){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","none");

        String res = restTemplate.getForObject(API_URL, String.class, vars);

        JSONObject rover = (JSONObject) getFirstPhotoJSON(res).get("rover");

        return  rover.getInt("max_sol");

    }

    private void addSolPhoto(int sol){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","" + sol);

        PhotosEntity photo = new PhotosEntity();

        try {

            String res = restTemplate.getForObject(API_URL, String.class, vars);

            photo.setUrl(getFirstPhotoJSON(res).getString("img_src"));
            photo.setSol(sol);

            photoServiceImpl.addPhoto(photo);

        }
        catch (HttpClientErrorException e){

            System.out.format(NO_PHOTO_WARN, sol);
            System.out.println();

            photo.setUrl(ANGRY_BATKO_IMG);
            photo.setSol(sol);

            photoServiceImpl.addPhoto(photo);
        }

    }


    //Для тестового режим
    //@Scheduled(fixedRate = 10000)
    //В боевом режиме
    @Scheduled(fixedRate = 88775245)
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

            current_sol = getMaxSolFromNASA();

            //На время тестирования используем предпоследний сол

            //current_sol = getMaxSolFromNASA() - 1;

        }

        addSolPhoto(current_sol);

    }


}
