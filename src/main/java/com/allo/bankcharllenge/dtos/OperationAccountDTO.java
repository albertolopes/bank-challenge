package com.allo.bankcharllenge.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OperationAccountDTO {

    private Integer contaNumero;

    private Float saldo;
}
