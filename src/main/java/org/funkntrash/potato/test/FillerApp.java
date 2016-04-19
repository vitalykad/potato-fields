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


public class FillerApp {


    public static void main(String[] args) {

        PhotoService photoService = new PhotoServiceImpl();


        for (int i=1314; i < 1315; i++){

            Map<String,String> vars = new HashMap<String, String>();
            vars.put("sol","" + i);

            System.out.println(""+i);

            String res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);
            System.out.println(res);

            JSONObject json = new JSONObject(res);
            JSONArray photosArray = (JSONArray) json.get("photos");
            JSONObject firstPhoto = (JSONObject) photosArray.get(0);

            System.out.println(firstPhoto.getString("img_src"));

            PhotosEntity photo = new PhotosEntity();
            photo.setSol(i);
            photo.setUrl(firstPhoto.getString("img_src"));
            photoService.addPhoto(photo);

        }

      /*  PhotosEntity photo = new PhotosEntity();
        photo.setUrl("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01001/opgs/edr/fcam/FLB_486349618EDR_F0481570FHAZ00323M_.JPG");
        photo.setSol(1002);

        PhotoService photoService = new PhotoServiceImpl();
        //photoService.addPhoto(photo);AppMain

        List<PhotosEntity> result = photoService.listPhotos();

        for ( PhotosEntity photosEntity : result ) {
            System.out.println( photosEntity.getSol() );
        }*/

/*
        PhotosEntity photosEntity = new PhotoServiceImpl().getMaxSolPhoto();

        if (photosEntity != null){

            System.out.println(photosEntity.getSol() + " " + photosEntity.getUrl());

        }
        else {
            System.out.print("null!");
        }



        Map<String,String> vars = new HashMap<String, String>();
        vars.put("sol","1002");

        String res = new RestTemplate().getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol={sol}&camera=fhaz&api_key=ZgBmbEEGqmmJt3v9VyFDhcTHYPMGFYTNoPOUWIUS", String.class, vars);

        JSONObject json = new JSONObject(res);
        JSONArray photosArray = (JSONArray) json.get("photos");
        JSONObject firstPhoto = (JSONObject) photosArray.get(0);


        System.out.println(firstPhoto.get("img_src"));

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
