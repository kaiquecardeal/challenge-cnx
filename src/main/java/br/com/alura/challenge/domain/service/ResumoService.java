package br.com.alura.challenge.domain.service;

import br.com.alura.challenge.dto.response.CategoriaResponse;
import br.com.alura.challenge.dto.response.ResumoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResumoService {

    private final ReceitaService receitaService;
    private final DespesaService despesaService;

    public ResumoResponse resumoMensal(Integer ano, Integer mes) {

        Double valorTotalReceitas = receitaService.findTotalAmountByMounth(ano, mes);
        Double valorTotalDespesas = despesaService.findTotalAmountByMounth(ano, mes);

        Double saldoFinal = valorTotalReceitas - valorTotalDespesas;

        List<CategoriaResponse> valorTotalPorCategoria = despesaService.findTotalAmountByCategoria(ano, mes);
        return ResumoResponse.builder()
                .totalReceitas(valorTotalReceitas)
                .totalDespesas(valorTotalDespesas)
                .saldoFinal(saldoFinal)
                .totalPorCategoria(valorTotalPorCategoria)
                .build();
    }
}