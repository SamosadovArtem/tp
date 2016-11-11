package com.ticket.repository;

import com.ticket.models.AbstractEntity;

import java.util.List;

/**
 * Created by Admin on 02.08.2016.
 */

public interface CRUDRepository<EntityType extends AbstractEntity> {

    public List<EntityType> findAll();

    public EntityType findById(int id);

    public void save(EntityType currentEntity);

    public void delete(EntityType currentEntity);

    public void update(EntityType currentEntity);

    public void deleteById(int id);
}
