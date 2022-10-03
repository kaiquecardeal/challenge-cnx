package br.com.alura.challenge.dto.mapper;

import br.com.alura.challenge.domain.entity.Despesa;
import br.com.alura.challenge.dto.request.DespesaRequest;
import br.com.alura.challenge.dto.response.DespesaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DespesaMapper {

    Despesa toRequestToEntity(DespesaRequest despesaRequest);

    DespesaResponse toEntityToResponse(Despesa despesa);

    List<DespesaResponse> toEntityListToResponse(List<Despesa> despesas);
}