package com.allo.bankcharllenge.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TransferAccountDTO {

    private Integer contaOrigemNumero;

    private Integer contaDestinoNumero;

    private Float valor;
}
