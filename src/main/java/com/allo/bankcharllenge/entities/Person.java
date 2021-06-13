package com.allo.bankcharllenge.entities;

import lombok.*;

import javax.persistence.*;

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
    private String name;

    @Column(name = "CPF")
    private Long cpf;

    @OneToOne(mappedBy="person")
    private Account account;
}