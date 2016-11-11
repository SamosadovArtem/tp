package com.ticket.repository.impl;

import com.ticket.models.AbstractEntity;
import com.ticket.repository.CRUDRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 28.07.2016.
 */
@Component
public abstract class CRUDRepositoryImpl<EntityType extends AbstractEntity> implements CRUDRepository<EntityType>{

    @PersistenceContext
    private EntityManager em;

    private Class clazz;

    public CRUDRepositoryImpl(Class clazz){
        this.clazz = clazz;
    }

    public List<EntityType> findAll(){
        Query query = em.createQuery("select o from " + clazz.getSimpleName() + " o");
        return (List<EntityType>) query.getResultList();
    }

    public EntityType findById(int id){
        return (EntityType)em.find(clazz,id);
    }

    public void save(EntityType currentEntity){
        em.persist(currentEntity);
    }

    public void delete(EntityType currentEntity){
        em.remove(currentEntity);
    }

    public void deleteById(int id){
        Query query = em.createQuery("DELETE FROM " + clazz.getSimpleName() + " c WHERE c.id = :deleteId");
        query.setParameter("deleteId", id).executeUpdate();
    }

    public void update(EntityType currentEntity){
        em.merge(currentEntity);
    }
}
