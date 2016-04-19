package org.funkntrash.potato.services;

import org.funkntrash.potato.models.PhotosEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by funkntrash on 18.04.16.
 */
public class Scheduler {

    private static int current_sol = 0;
    private static final String ANGRY_BATKO_IMG="http://image.zn.ua/media/images/original/Jan2015/107798.jpg";
    private static final String API_URL="https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS";


    private int getMaxSolFromNASA(){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","none");


        String res = new RestTemplate().getForObject(API_URL, String.class, vars);
        JSONObject json = new JSONObject(res);
        JSONArray photosArray = (JSONArray) json.get("photos");
        JSONObject firstPhoto = (JSONObject) photosArray.get(0);
        JSONObject rover = (JSONObject) firstPhoto.get("rover");

        return  rover.getInt("max_sol");

    }

    private void addSolPhoto(int sol){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","" + sol);

        PhotoService photoService = new PhotoServiceImpl();

        try {
            String res = new RestTemplate().getForObject(API_URL, String.class, vars);
            JSONObject json = new JSONObject(res);
            JSONArray photosArray = (JSONArray) json.get("photos");
            JSONObject firstPhoto = (JSONObject) photosArray.get(0);
            PhotosEntity photo = new PhotosEntity();
            photo.setUrl(firstPhoto.getString("img_src"));
            photo.setSol(sol);

            photoService.addPhoto(photo);

        }
        catch (HttpClientErrorException e){
            System.out.print("Батько недоволен");

            PhotosEntity photo = new PhotosEntity();
            photo.setUrl(ANGRY_BATKO_IMG);
            photo.setSol(sol);

            photoService.addPhoto(photo);
        }

    }

    //@Scheduled(fixedRate = 88775245)
    @Scheduled(fixedRate = 10000)
    public void clearTempFolder() {

        PhotoService photoService = new PhotoServiceImpl();
        PhotosEntity photosEntity = photoService.getMaxSolPhoto();

        if (photosEntity != null){

            if (current_sol == 0) {
                current_sol = photosEntity.getSol() + 1;
            } else {
                current_sol++;
            }

        }
        else {

            //На время тестирования используем вчерашний сол

            current_sol = getMaxSolFromNASA() - 1;

        }

        addSolPhoto(current_sol);

    }



}
