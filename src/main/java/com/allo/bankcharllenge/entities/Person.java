package com.allo.bankcharllenge.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Long id;

    @Column(name = "NAME")
    private String nome;

    @NotEmpty(message = "É necessário informar um cpf para abertura de nova conta.")
    @CPF(message = "CPF informado para criação de conta está inválido.")
    @Column(name = "CPF")
    private String cpf;

    @OneToOne(mappedBy="pessoa")
    private Account conta;
}
