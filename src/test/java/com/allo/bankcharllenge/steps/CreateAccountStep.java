package com.allo.bankcharllenge.steps;

import com.allo.bankcharllenge.dtos.CreateAccountDTO;
import cucumber.api.java.gl.Dado;

import java.util.List;

public class CreateAccountStep{

    private CreateAccountDTO createAccount =  new CreateAccountDTO();

    @Dado("^que seja solicitada a criação de uma nova conta com os seguintes valores")
    public void create_a_request_with_following_values(List<CreateAccountDTO> values){
        createAccount.setNome(values.get(0).getNome());
        createAccount.setCpf(values.get(0).getCpf());
        createAccount.setSaldo(values.get(0).getSaldo());
    }
}
