package org.funkntrash.potato.test;

/**
 * Created by Home on 16.04.2016.
 */

import org.funkntrash.potato.domain.PhotoDAO;
import org.funkntrash.potato.domain.PhotoDAOImpl;
import org.funkntrash.potato.models.PhotosEntity;
import org.funkntrash.potato.services.PhotoService;
import org.funkntrash.potato.services.PhotoServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class AppMain {

    public static final String SELECT_QUERY =
            "from PhotosEntity";

    public static void main(String[] args) {

        PhotosEntity photo = new PhotosEntity();
        photo.setUrl("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01001/opgs/edr/fcam/FLB_486349618EDR_F0481570FHAZ00323M_.JPG");
        photo.setSol(1002);

        PhotoService photoService = new PhotoServiceImpl();
        //photoService.addPhoto(photo);

        List<PhotosEntity> result = photoService.listPhotos();

        for ( PhotosEntity photosEntity : result ) {
            System.out.println( photosEntity.getSol() );
        }



        /*    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(SELECT_QUERY).getResultList();

        System.out.println( "Select ok");

        for ( PhotosEntity photosEntity : result ) {
            System.out.println( photosEntity.getSol() );
        }
      /*  PhotosEntity photosEntity = new PhotosEntity();
        photosEntity.setUrl("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01001/opgs/edr/fcam/FLB_486349618EDR_F0481570FHAZ00323M_.JPG");
        photosEntity.setSol(1001);
        entityManager.persist(photosEntity);
        entityManager.getTransaction().commit();
        entityManager.close();*/

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
