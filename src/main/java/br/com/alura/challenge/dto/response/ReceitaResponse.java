package br.com.alura.challenge.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReceitaResponse implements Serializable {

    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;
}
