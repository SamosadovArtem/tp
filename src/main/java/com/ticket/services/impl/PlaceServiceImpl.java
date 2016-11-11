package com.ticket.services.impl;

import com.ticket.models.Place;
import com.ticket.repository.PlaceRepository;
import com.ticket.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 05.08.2016.
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    @Transactional
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }
}
