package br.com.alura.challenge.dto.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReceitaRequest implements Serializable {

    @NotBlank
    private String descricao;
    private Double valor;
    @CreationTimestamp
    private LocalDate data;
}