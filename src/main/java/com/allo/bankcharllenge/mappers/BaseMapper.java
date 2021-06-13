package com.allo.bankcharllenge.mappers;

import com.allo.bankcharllenge.dtos.CreateAccountDTO;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(CreateAccountDTO dto);

    List<D> toDto(List<E> entities);

    List<E> toEntity(List<D> dtos);

}