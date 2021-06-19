package com.allo.bankcharllenge.services;

import com.allo.bankcharllenge.dtos.AccountDTO;
import com.allo.bankcharllenge.dtos.CreateAccountDTO;
import com.allo.bankcharllenge.entities.Account;
import com.allo.bankcharllenge.entities.Person;
import com.allo.bankcharllenge.mappers.AccountMapper;
import com.allo.bankcharllenge.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.lang.Long.parseLong;


@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountDTO createAccount(CreateAccountDTO dto){
        Person person = new Person();
        person.setNome(dto.getNome());
        person.setCpf(dto.getCpf());

        Account account = new Account();
        account.setPessoa(person);
        account.setSaldo(dto.getSaldo());
        account.setContaNumero(new Random().nextInt(999999));

        return accountMapper.toDto(accountRepository.save(account));
    }
}
