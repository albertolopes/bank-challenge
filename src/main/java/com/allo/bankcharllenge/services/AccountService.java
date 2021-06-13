package com.allo.bankcharllenge.services;

import com.allo.bankcharllenge.dtos.CreateAccountDTO;
import com.allo.bankcharllenge.entities.Account;
import com.allo.bankcharllenge.mappers.AccountMapper;
import com.allo.bankcharllenge.mappers.CreateAccountMapper;
import com.allo.bankcharllenge.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final CreateAccountMapper createAccountMapper;

    public CreateAccountDTO createAccount(CreateAccountDTO dto) {
        return createAccountMapper.toDto(createAccountMapper.toEntity(dto));
    }
}
