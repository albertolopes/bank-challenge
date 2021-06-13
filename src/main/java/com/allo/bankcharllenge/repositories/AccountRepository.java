package com.allo.bankcharllenge.repositories;

import com.allo.bankcharllenge.dtos.CreateAccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Long, CreateAccountDTO> {
}
