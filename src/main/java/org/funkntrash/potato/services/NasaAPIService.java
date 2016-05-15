package org.funkntrash.potato.services;

import org.funkntrash.potato.models.PhotosEntity;
import org.funkntrash.potato.nasa.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 09.05.16.
 */

@Component
public class NasaAPIService {
    @Autowired
    private NasaAPI nasaAPI;
    @Autowired
    private PhotoService photoServiceImpl;

    private static final String API_URL="https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS";
    private static final String NO_PHOTO_WARN="Отсутствует фото за сол %d";

    private static RestTemplate restTemplate = new RestTemplate();

    public int getMaxSol(){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","none");

        nasaAPI = restTemplate.getForObject(API_URL, NasaAPI.class, vars);

        return nasaAPI.getPhotos().get(0).getRover().getMaxSol();

    }

    public String getPhotoSrc(int sol){

        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","" + sol);

        try {

            nasaAPI = restTemplate.getForObject(API_URL, NasaAPI.class, vars);
            return nasaAPI.getPhotos().get(0).getImgSrc();

        }
        catch (HttpClientErrorException e){

            System.out.format(NO_PHOTO_WARN, sol);
            System.out.println();

            return  "";

        }



    }

}
