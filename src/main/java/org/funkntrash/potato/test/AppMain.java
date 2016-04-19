package org.funkntrash.potato.test;

/**
 * Created by Home on 16.04.2016.
 */


import org.funkntrash.potato.domain.PhotoDAO;
import org.funkntrash.potato.domain.PhotoDAOImpl;
import org.funkntrash.potato.models.PhotosEntity;
import org.funkntrash.potato.services.PhotoService;
import org.funkntrash.potato.services.PhotoServiceImpl;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.transform.Source;


import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class AppMain {

    //public static int current_sol = 0;

    public static void main(String[] args) {


        PhotoService photoService = new PhotoServiceImpl();
        PhotosEntity photosEntity = photoService.getMaxSolPhoto();

/*
        if (photosEntity != null){

            if (current_sol == 0) {
                current_sol = photosEntity.getSol() + 1;
            } else {
                current_sol++;
            }


            Map<String,String> vars = new HashMap<String, String>();
            vars.put("sol","" + current_sol);

            try {
                String res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);
                JSONObject json = new JSONObject(res);
                JSONArray photosArray = (JSONArray) json.get("photos");
                JSONObject firstPhoto = (JSONObject) photosArray.get(0);
                PhotosEntity photo = new PhotosEntity();
                photo.setUrl(firstPhoto.getString("img_src"));
                photo.setSol(current_sol);

                photoService.addPhoto(photo);

            }
            catch (HttpClientErrorException e){
                System.out.print("Батько недоволен");

                PhotosEntity photo = new PhotosEntity();
                photo.setUrl("http://image.zn.ua/media/images/original/Jan2015/107798.jpg");
                photo.setSol(current_sol);

                photoService.addPhoto(photo);
            }



        }
        else {
            Map<String,String> vars = new HashMap<String, String>();
            vars.put("sol","none");


                String res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);
                JSONObject json = new JSONObject(res);
                JSONArray photosArray = (JSONArray) json.get("photos");
                JSONObject firstPhoto = (JSONObject) photosArray.get(0);
                JSONObject rover = (JSONObject) firstPhoto.get("rover");

                current_sol = rover.getInt("max_sol") - 1;

            try {
                vars.put("sol",""+ current_sol);

                res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);

                json = new JSONObject(res);
                photosArray = (JSONArray) json.get("photos");
                firstPhoto = (JSONObject) photosArray.get(0);

                PhotosEntity photo = new PhotosEntity();
                photo.setUrl(firstPhoto.getString("img_src"));
                photo.setSol(current_sol);

                photoService.addPhoto(photo);

            }
            catch (HttpClientErrorException e){                PhotosEntity photo = new PhotosEntity();
                photo.setUrl(firstPhoto.getString("img_src"));
                photo.setSol(current_sol);

                photoService.addPhoto(photo);
                System.out.print("Батько недоволен");

                PhotosEntity photo = new PhotosEntity();
                photo.setUrl("http://image.zn.ua/media/images/original/Jan2015/107798.jpg");
                photo.setSol(current_sol);

                photoService.addPhoto(photo);
            }


        }


*/
/*        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","1002");

        String res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);

        JSONObject json = new JSONObject(res);
        JSONArray photosArray = (JSONArray) json.get("photos");
        JSONObject firstPhoto = (JSONObject) photosArray.get(0);


        System.out.println(firstPhoto.get("img_src"));*/

        //RestTemplate restTemplate = new RestTemplate();


        //MappingJacksonHttpMessageConverter


        //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        //PhotosJson[] photosJsons = restTemplate.getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", PhotosJson[].class, vars);


        /*    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(SELECT_QUERY).getResultList();

        System.out.println( "Select ok");

        for ( PhotosEntity photosEntity : result ) {
            System.out.println( photosEntity.getSol() );
        }*/


        /*     EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        List<PhotosEntity> result = em.createQuery(SELECT_QUERY, PhotosEntity.class).getResultList(); //em.createQuery( "from PhotosEntity ", PhotosEntity.class ).getResultList();

        for (PhotosEntity photosEntity :result){
            System.out.println(photosEntity.getSol() + " " + photosEntity.getUrl());
        }

        em.getTransaction().commit();
        em.close();
        /*       PhotosEntity photosEntity = new PhotosEntity();
        photosEntity.setUrl("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01001/opgs/edr/fcam/FLB_486349618EDR_F0481570FHAZ00323M_.JPG");
        photosEntity.setSol(1001);
        em.persist(photosEntity);
        em.getTransaction().commit();
*/
    }
}
