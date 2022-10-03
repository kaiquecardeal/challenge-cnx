package br.com.alura.challenge.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "receitas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, length = 4000)
    private String descricao;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @Column(name = "data", nullable = false)
    private LocalDate data;
}