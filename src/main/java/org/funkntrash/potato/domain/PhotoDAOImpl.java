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

    private EntityManager entityManager;
    private static final String SELECT_ALL_PHOTOS_QUERY = " from PhotosEntity order by sol desc ";
    private static final String SELECT_PHOTO_WITH_MAX_SOL_QUERY = " from PhotosEntity pe where pe.sol in (select max(p.sol) from PhotosEntity p) ";

    public PhotoDAOImpl(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();

    }

    public List<PhotosEntity> listPhoto(){

        entityManager.getTransaction().begin();

        List<PhotosEntity> result = entityManager.createQuery(SELECT_ALL_PHOTOS_QUERY).getResultList();

        entityManager.getTransaction().commit();

        return result;
    }

    public void addPhoto(PhotosEntity photosEntity){

        entityManager.getTransaction().begin();

        entityManager.persist(photosEntity);

        entityManager.getTransaction().commit();

    }

    public PhotosEntity getMaxSolPhoto(){

        entityManager.getTransaction().begin();

        // не разобрал почему не сработало
        // PhotosEntity result = entityManager.createQuery(" from PhotosEntity where sol=max(sol) ").getResultList().get(0);

        List<PhotosEntity> photoList =  entityManager.createQuery(SELECT_PHOTO_WITH_MAX_SOL_QUERY).getResultList();


        entityManager.getTransaction().commit();

        if (!photoList.isEmpty()) {
            return photoList.get(0);
        }
        else {
            return null;
        }

    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
