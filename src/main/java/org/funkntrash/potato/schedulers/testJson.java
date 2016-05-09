package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.nasa.entities.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

/**
 * Created by root on 09.05.16.
 */
public class testJson {

    public static void main(String args[ ])
    {
        System.out.println("!!!!!!!!!!!!!!!!!");

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1300&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS";

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the Jackson message converter
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

// Make the HTTP GET request, marshaling the response from JSON to an array of Events
        NasaAPI nasaApi = restTemplate.getForObject(url, NasaAPI.class);

        for (Photo photo : nasaApi.getPhotos()){
            System.out.println(photo.getImgSrc());
        }

    }
}
