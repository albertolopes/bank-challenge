package com.allo.bankcharllenge.services;

import com.allo.bankcharllenge.dtos.*;
import com.allo.bankcharllenge.entities.Account;
import com.allo.bankcharllenge.entities.Person;
import com.allo.bankcharllenge.exceptions.DataIntegrityException;
import com.allo.bankcharllenge.exceptions.ObjectNotFoundException;
import com.allo.bankcharllenge.mappers.AccountMapper;
import com.allo.bankcharllenge.mappers.DepositAccountMapper;
import com.allo.bankcharllenge.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final DepositAccountMapper depositMapper;

    @Transactional
    public AccountDTO createAccount(CreateAccountDTO dto){

        if(dto.getSaldo() < 50)
            throw new DataIntegrityException("Saldo insuficiente para abertura de nova conta.");

        Person person = new Person();
        person.setNome(dto.getNome());
        person.setCpf(dto.getCpf());

        Account account = new Account();
        account.setPessoa(person);
        account.setSaldo(dto.getSaldo());
        account.setContaNumero(new Random().nextInt(999999));

        return accountMapper.toDto(accountRepository.save(account));
    }

    @Transactional
    public OperationResponseDTO depositAccount(OperationAccountDTO dto){
        Account currentAcount = accountRepository
                .findByContaNumero(dto.getContaNumero())
                .orElseThrow(() -> new ObjectNotFoundException("Conta não existe."));

        currentAcount.setSaldo(currentAcount.getSaldo() + dto.getSaldo());

        OperationResponseDTO responseDto = depositMapper.toDto(accountRepository.save(currentAcount));
        responseDto.setMensagem("Depósito realizado com sucesso!");

        return responseDto;
    }

    @Transactional
    public OperationResponseDTO withdrawAccount(OperationAccountDTO dto) {
        if(dto.getSaldo() > 500)
            throw new DataIntegrityException("Operação de transferência tem um limite máximo de 500 por operação.");

        Account currentAcount = accountRepository
                .findByContaNumero(dto.getContaNumero())
                .orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada."));

        if(currentAcount.getSaldo() < dto.getSaldo())
            throw new DataIntegrityException("Saldo insuficiente para a operação.");

        currentAcount.setSaldo(currentAcount.getSaldo() - dto.getSaldo());

        OperationResponseDTO responseDto = depositMapper.toDto(accountRepository.save(currentAcount));
        responseDto.setMensagem("Saque realizado com sucesso!");

        return responseDto;
    }

    @Transactional
    public TransferResponseDTO transferAccount(TransferAccountDTO dto) {
        if(dto.getValor() > 500)
            throw new DataIntegrityException("Operação de transferência tem um limite máximo de 500 por operação.");

        Account originAcount = accountRepository
                .findByContaNumero(dto.getContaOrigemNumero())
                .orElseThrow(() -> new ObjectNotFoundException("Conta do solicitante não encontrada."));

        if(originAcount.getSaldo() < dto.getValor())
            throw new DataIntegrityException("Saldo insuficiente para a operação.");

        Account destinationAcount = accountRepository
                .findByContaNumero(dto.getContaDestinoNumero())
                .orElseThrow(() -> new ObjectNotFoundException("Conta do beneficiário não encontrada."));

        originAcount.setSaldo(originAcount.getSaldo() - dto.getValor());
        destinationAcount.setSaldo(destinationAcount.getSaldo() + dto.getValor());

        originAcount = accountRepository.save(originAcount);
        destinationAcount = accountRepository.save(destinationAcount);

        TransferResponseDTO transferResponse =  new TransferResponseDTO();
        transferResponse.setContaOrigemNumero(originAcount.getContaNumero());
        transferResponse.setContaOrigemSaldo(originAcount.getSaldo());

        transferResponse.setContaDestinoNumero(destinationAcount.getContaNumero());
        transferResponse.setContaDestinoSaldo(destinationAcount.getSaldo());


        transferResponse.setMensagem("Transferência realizada com sucesso!");

        return transferResponse;
    }
}
