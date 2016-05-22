package org.funkntrash.potato.services;

import org.funkntrash.potato.nasa.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 09.05.16.
 */

@Component
public class NasaAPIService {
    @Autowired
    private NasaAPI nasaAPI;

    final static Logger logger = Logger.getLogger(NasaAPIService.class);

    private String API_URL="";
    private String NO_PHOTO_WARN="";

    @Value("#{urls.API_URL}")
    public void setAPI_URL(String API_URL) {
        this.API_URL = API_URL;
    }

    @Value("#{messages.NO_PHOTO_WARN}")
    public void setNO_PHOTO_WARN(String NO_PHOTO_WARN) {
        this.NO_PHOTO_WARN = NO_PHOTO_WARN;
    }

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

            logger.warn("\n\n" + NO_PHOTO_WARN + " " + sol +"\n");

            return  "";

        }



    }

}
