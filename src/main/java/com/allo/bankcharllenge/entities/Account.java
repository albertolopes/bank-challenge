package com.allo.bankcharllenge.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACCOUNT")
    private Long id;

    @Column(name = "ACCOUNT_NUMBER")
    private Integer contaNumero;

    @Column(name = "BALANCE")
    private Float saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person pessoa;
}
