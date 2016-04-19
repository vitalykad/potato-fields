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

    public PhotosEntity getMaxSolPhoto(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // не разобрал почему не сработало
        // PhotosEntity result = entityManager.createQuery(" from PhotosEntity where sol=max(sol) ").getResultList().get(0);

        List<PhotosEntity> photoList =  entityManager.createQuery(" from PhotosEntity pe where pe.sol in (select max(p.sol) from PhotosEntity p) ").getResultList();


        entityManager.getTransaction().commit();
        entityManager.close();


        if (!photoList.isEmpty()) {
            return photoList.get(0);
        }
        else{
            return null;
        }

    }
}