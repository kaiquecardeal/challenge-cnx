package br.com.alura.challenge.dto.mapper;

import br.com.alura.challenge.domain.entity.Receita;
import br.com.alura.challenge.dto.request.ReceitaRequest;
import br.com.alura.challenge.dto.response.ReceitaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceitaMapper {

    Receita toRequestToEntity(ReceitaRequest receitaRequest);

    ReceitaResponse toEntityToResponse(Receita receita);

    List<ReceitaResponse> toEntityListToResponse(List<Receita> receitas);
}