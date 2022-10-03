package br.com.alura.challenge.dto.response;

import br.com.alura.challenge.domain.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponse implements Serializable {

    private Categoria categoria;
    private Double total;
}