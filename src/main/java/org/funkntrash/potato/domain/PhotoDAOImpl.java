package org.funkntrash.potato.domain;

import org.funkntrash.potato.models.PhotosEntity;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */

@Component
public class PhotoDAOImpl implements PhotoDAO {

    private  EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static final String SELECT_ALL_PHOTOS_QUERY = " from PhotosEntity order by sol desc ";
    private static final String SELECT_PHOTO_WITH_MAX_SOL_QUERY = " from PhotosEntity pe where pe.sol in (select max(p.sol) from PhotosEntity p) ";

    public PhotoDAOImpl(){

        entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    }

    public List<PhotosEntity> listPhoto(){

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(SELECT_ALL_PHOTOS_QUERY).getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        return result;
    }

    public void addPhoto(PhotosEntity photosEntity){

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(photosEntity);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public PhotosEntity getMaxSolPhoto(){

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // не разобрал почему не сработало
        // PhotosEntity result = entityManager.createQuery(" from PhotosEntity where sol=max(sol) ").getResultList().get(0);

        List<PhotosEntity> photoList =  entityManager.createQuery(SELECT_PHOTO_WITH_MAX_SOL_QUERY).getResultList();


        entityManager.getTransaction().commit();

        entityManager.close();


        if (!photoList.isEmpty()) {
            return photoList.get(0);
        }
        else {
            return null;
        }


    }

    @Override
    protected void finalize() throws Throwable {
        //entityManager.close();
        super.finalize();
    }
}
