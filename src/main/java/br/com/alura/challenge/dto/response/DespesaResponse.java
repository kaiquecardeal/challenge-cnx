package br.com.alura.challenge.dto.response;

import br.com.alura.challenge.domain.entity.Categoria;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data

public class DespesaResponse implements Serializable {

    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;
    private Categoria categoria;
}