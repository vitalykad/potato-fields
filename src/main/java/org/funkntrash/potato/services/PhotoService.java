package org.funkntrash.potato.services;

import org.funkntrash.potato.models.PhotosEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Home on 17.04.2016.
 */
public class PhotoService {
    public static List<PhotosEntity> getAll() {



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(" from PhotosEntity").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();



        return result;
    }

    public static PhotosEntity get() {

        PhotosEntity photo = new PhotosEntity();

        photo.setId(1);
        photo.setUrl("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01002/opgs/edr/fcam/FLB_486444942EDR_F0481570FHAZ00323M_.JPG");
        photo.setSol(1002);


        return photo;
    }
}
