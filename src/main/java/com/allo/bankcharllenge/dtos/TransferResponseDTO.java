package com.allo.bankcharllenge.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TransferResponseDTO {

    private Integer contaOrigemNumero;

    private Float contaOrigemSaldo;

    private Integer contaDestinoNumero;

    private Float contaDestinoSaldo;

    private String mensagem;
}

