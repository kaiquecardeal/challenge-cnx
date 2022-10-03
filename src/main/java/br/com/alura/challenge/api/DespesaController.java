package br.com.alura.challenge.api;

import br.com.alura.challenge.api.doc.DespesaControllerDoc;
import br.com.alura.challenge.domain.entity.Despesa;
import br.com.alura.challenge.domain.service.DespesaService;
import br.com.alura.challenge.dto.request.DespesaRequest;
import br.com.alura.challenge.dto.response.DespesaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/despesas")
@RequiredArgsConstructor
@CrossOrigin
public class DespesaController implements DespesaControllerDoc {

    private final DespesaService despesaService;

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Despesa>> listarDespesas() {
        return ResponseEntity.ok(despesaService.listarDespesas());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DespesaResponse> detalharDespesa(@PathVariable Long idDespesa) {
        return ResponseEntity.ok(despesaService.detalharDespesa(idDespesa));
    }

    @Override
    @PostMapping
    public ResponseEntity<DespesaResponse> inserirDespesa(@Valid @RequestBody DespesaRequest despesaRequest) {
        return new ResponseEntity<>(despesaService.inserirDespesa(despesaRequest), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DespesaResponse> atualizarDespesa(@PathVariable Long idDespesa, @Valid @RequestBody DespesaRequest despesaRequest) {
        return ResponseEntity.ok(despesaService.atualizarDespesa(idDespesa, despesaRequest));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDespesa(@PathVariable Long idDespesa) {
        despesaService.deletarDespesa(idDespesa);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping(value = "/{ano}/{mes}")
    public List<DespesaResponse> buscarPorAnoMes(@PathVariable(value = "ano") Integer ano, @PathVariable(value = "mes") Integer mes) {
        return despesaService.buscarPorAnoMes(ano, mes);
    }

    @Override
    @GetMapping
    public ResponseEntity<DespesaResponse> buscarDespesaPorDescricao(@PathParam(value = "descricao") String descricao) {
        return ResponseEntity.ok(despesaService.buscarDespesaPorDescricao(descricao));
    }
}