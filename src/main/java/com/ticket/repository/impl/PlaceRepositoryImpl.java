package com.ticket.repository.impl;

import com.ticket.models.Place;
import com.ticket.repository.PlaceRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link PlaceRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class PlaceRepositoryImpl extends CRUDRepositoryImpl<Place> implements PlaceRepository {

    public PlaceRepositoryImpl() {
        super(Place.class);
    }
}
