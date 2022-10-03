package br.com.alura.challenge.api.doc;

import br.com.alura.challenge.domain.entity.Despesa;
import br.com.alura.challenge.dto.request.DespesaRequest;
import br.com.alura.challenge.dto.response.DespesaResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DespesaControllerDoc {

    ResponseEntity<List<Despesa>> listarDespesas();

    ResponseEntity<DespesaResponse> detalharDespesa(Long idDespesa);

    ResponseEntity<DespesaResponse> inserirDespesa(DespesaRequest despesaRequest);

    ResponseEntity<DespesaResponse> atualizarDespesa(Long idDespesa, DespesaRequest despesaRequest);

    ResponseEntity<?> deletarDespesa(Long idDespesa);

    List<DespesaResponse> buscarPorAnoMes(Integer ano, Integer mes);

    ResponseEntity<DespesaResponse> buscarDespesaPorDescricao(String descricao);
}