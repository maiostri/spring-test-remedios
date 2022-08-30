package com.ada.springtestremedios.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Remedio {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
}
