package org.funkntrash.potato.domain;

import org.funkntrash.potato.models.PhotosEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by funkntrash on 18.04.16.
 */

@Repository
public class PhotoDAOImpl implements PhotoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String SELECT_ALL_PHOTOS_QUERY = " select pe from PhotosEntity pe order by sol desc ";
    private static final String SELECT_PHOTO_WITH_MAX_SOL_QUERY = "select pe from PhotosEntity pe where pe.sol in (select max(p.sol) from PhotosEntity p) ";


    public List<PhotosEntity> listPhoto(){

        List<PhotosEntity> result = entityManager.createQuery(SELECT_ALL_PHOTOS_QUERY).getResultList();

        return result;
    }

    public void addPhoto(PhotosEntity photosEntity){

        entityManager.persist(photosEntity);

    }

    public PhotosEntity getMaxSolPhoto(){

        List<PhotosEntity> photoList =  entityManager.createQuery(SELECT_PHOTO_WITH_MAX_SOL_QUERY).getResultList();

        if (!photoList.isEmpty()) {
            return photoList.get(0);
        }
        else {
            return null;
        }


    }

}
