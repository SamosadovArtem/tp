package com.ticket.repository.impl;

import com.ticket.models.City;
import com.ticket.repository.CityRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link CityRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class CityRepositoryImpl extends CRUDRepositoryImpl<City> implements CityRepository{

    public CityRepositoryImpl() {
        super(City.class);
    }
}
