package com.allo.bankcharllenge.services;

import com.allo.bankcharllenge.entities.Person;
import com.allo.bankcharllenge.mappers.CreatePersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final CreatePersonMapper mapper;


}
