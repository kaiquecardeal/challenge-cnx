package br.com.alura.challenge.api;

import br.com.alura.challenge.api.doc.ReicetaControllerDoc;
import br.com.alura.challenge.domain.entity.Receita;
import br.com.alura.challenge.domain.service.ReceitaService;
import br.com.alura.challenge.dto.request.ReceitaRequest;
import br.com.alura.challenge.dto.response.ReceitaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/api/receitas")
@RequiredArgsConstructor
@CrossOrigin
public class ReceitaController implements ReicetaControllerDoc {

    private final ReceitaService receitaService;

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok(receitaService.listaReceitas());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponse> detalharReceita(@PathVariable Long idReceita) {
        return ResponseEntity.ok(receitaService.detalharReceita(idReceita));
    }

    @Override
    @PostMapping
    public ResponseEntity<ReceitaResponse> inserirReceita(@Valid @RequestBody ReceitaRequest receitaRequest) {
        return new ResponseEntity<>(receitaService.inserirReceita(receitaRequest), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ReceitaResponse> atualizarReceita(@PathVariable Long idReceita, @Valid @RequestBody ReceitaRequest receitaRequest) {
        return ResponseEntity.ok(receitaService.atualizarReceita(idReceita, receitaRequest));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarReceita(Long idReceita) {
        receitaService.deletarReceita(idReceita);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{ano}/{mes}")
    public List<ReceitaResponse> buscarPorAnoMes(@PathVariable(value = "ano") Integer ano, @PathVariable(value = "mes") Integer mes) {
        return receitaService.buscarPorAnoMes(ano, mes);
    }

    @Override
    @GetMapping
    public ResponseEntity<ReceitaResponse> buscarDespesaPorDescricao(@PathParam(value = "descricao") String descricao) {
        return ResponseEntity.ok(receitaService.buscarReceitaPorDescricao(descricao));
    }
}