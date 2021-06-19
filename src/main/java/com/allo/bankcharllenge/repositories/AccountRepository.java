package com.allo.bankcharllenge.repositories;

import com.allo.bankcharllenge.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Transactional
    Optional<Account> findByContaNumero(Integer account);
}
