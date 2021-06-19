package com.allo.bankcharllenge.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OperationResponseDTO {

    private Integer contaNumero;

    private Float saldo;

    private String mensagem;
}
