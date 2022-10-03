package br.com.alura.challenge.api.doc;

import br.com.alura.challenge.dto.response.ResumoResponse;
import org.springframework.http.ResponseEntity;

public interface ResumoControllerDoc {

    ResponseEntity<ResumoResponse> resumoMensal(Integer ano, Integer mes);
}