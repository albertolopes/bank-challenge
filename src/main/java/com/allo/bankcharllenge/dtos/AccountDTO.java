package com.allo.bankcharllenge.dtos;

import com.allo.bankcharllenge.entities.Person;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountDTO {

    private Long id;

    private Integer contaNumero;

    private Float saldo;

    private PersonDTO pessoa;
}
