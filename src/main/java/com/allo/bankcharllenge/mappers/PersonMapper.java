package com.allo.bankcharllenge.mappers;

import com.allo.bankcharllenge.dtos.PersonDTO;
import com.allo.bankcharllenge.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper extends BaseMapper<Person, PersonDTO> {
}
