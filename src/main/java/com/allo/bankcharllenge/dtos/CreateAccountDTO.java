package com.allo.bankcharllenge.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateAccountDTO {

    private String nome;

    private String cpf;

    private Float saldo;
}
