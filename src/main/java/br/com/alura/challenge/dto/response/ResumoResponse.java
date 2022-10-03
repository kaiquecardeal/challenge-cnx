package br.com.alura.challenge.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ResumoResponse implements Serializable {

    private Double totalReceitas;
    private Double totalDespesas;
    private Double saldoFinal;
    private List<CategoriaResponse> totalPorCategoria;
}