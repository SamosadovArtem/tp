package com.ticket.services.impl;

import com.ticket.models.City;
import com.ticket.repository.CityRepository;
import com.ticket.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 05.08.2016.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
