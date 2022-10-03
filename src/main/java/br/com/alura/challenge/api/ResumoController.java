package br.com.alura.challenge.api;

import br.com.alura.challenge.api.doc.ResumoControllerDoc;
import br.com.alura.challenge.domain.service.ResumoService;
import br.com.alura.challenge.dto.response.ResumoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumos")
@RequiredArgsConstructor
@CrossOrigin
public class ResumoController implements ResumoControllerDoc {

    private final ResumoService resumoService;

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<ResumoResponse> resumoMensal(@PathVariable(value = "ano") Integer ano, @PathVariable(value = "mes") Integer mes) {
        return ResponseEntity.ok(resumoService.resumoMensal(ano, mes));
    }
}