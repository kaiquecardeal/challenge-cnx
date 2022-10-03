package br.com.alura.challenge.api.doc;

import br.com.alura.challenge.domain.entity.Receita;
import br.com.alura.challenge.dto.request.ReceitaRequest;
import br.com.alura.challenge.dto.response.ReceitaResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReicetaControllerDoc {

    ResponseEntity<List<Receita>> listarReceitas();

    ResponseEntity<ReceitaResponse> detalharReceita(Long idReceita);

    ResponseEntity<ReceitaResponse> inserirReceita(ReceitaRequest receitaRequest);

    ResponseEntity<ReceitaResponse> atualizarReceita(Long idReceita, ReceitaRequest receitaRequest);

    ResponseEntity<ReceitaResponse> buscarDespesaPorDescricao(String descricao);

    ResponseEntity<?> deletarReceita(Long idReceita);
}