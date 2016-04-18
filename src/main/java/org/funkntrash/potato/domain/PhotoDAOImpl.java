package org.funkntrash.potato.domain;

import org.funkntrash.potato.models.PhotosEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */
public class PhotoDAOImpl implements PhotoDAO {
    public List<PhotosEntity> listPhoto(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(" from PhotosEntity order by sol desc ").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();


        return result;
    }

    public void addPhoto(PhotosEntity photosEntity){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(photosEntity);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
