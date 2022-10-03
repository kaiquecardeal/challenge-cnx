package br.com.alura.challenge.domain.service;

import br.com.alura.challenge.domain.entity.Despesa;
import br.com.alura.challenge.domain.repository.DespesaRepository;
import br.com.alura.challenge.dto.mapper.DespesaMapper;
import br.com.alura.challenge.dto.request.DespesaRequest;
import br.com.alura.challenge.dto.response.CategoriaResponse;
import br.com.alura.challenge.dto.response.DespesaResponse;
import br.com.alura.challenge.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DespesaService {

    private final DespesaRepository despesaRepository;

    private final DespesaMapper despesaMapper;

    public List<Despesa> listarDespesas() {
        return despesaRepository.findAll();
    }

    public DespesaResponse detalharDespesa(Long idDespesa) {
        Despesa despesa = despesaRepository.findById(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException("DESPESA_NAO_ENCONTRADA"));
        return despesaMapper.toEntityToResponse(despesa);
    }

    public DespesaResponse inserirDespesa(DespesaRequest despesaRequest) {
        Despesa despesa = despesaMapper.toRequestToEntity(despesaRequest);
        despesa.setData(LocalDate.now());
        despesaRepository.save(despesa);
        return despesaMapper.toEntityToResponse(despesa);
    }

    public DespesaResponse atualizarDespesa(Long idDespesa, DespesaRequest despesaRequest) {
        Despesa despesa = despesaRepository.findById(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException("DESPESA_NAO_ENCONTRADA"));

        despesa.setDescricao(despesaRequest.getDescricao());
        despesa.setValor(despesaRequest.getValor());
        despesa.setData(LocalDate.now());
        return despesaMapper.toEntityToResponse(despesa);
    }

    public void deletarDespesa(Long idDespesa) {
        Despesa despesa = despesaRepository.findById(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException("DESPESA_NAO_ENCONTRADA"));
        despesaRepository.delete(despesa);
    }

    public List<DespesaResponse> buscarPorAnoMes(Integer ano, Integer mes) {
        return despesaMapper.toEntityListToResponse(despesaRepository.buscarPorAnoMes(ano, mes));
    }

    public DespesaResponse buscarDespesaPorDescricao(String descricao) {
        Despesa despesa = despesaRepository.findByDescricao(descricao)
                .orElseThrow(() -> new ResourceNotFoundException("DESPESA_NAO_ENCONTRADA"));
        return despesaMapper.toEntityToResponse(despesa);
    }

    public Double findTotalAmountByMounth(Integer ano, Integer mes) {
        return despesaRepository.findTotalAmountByMounth(ano, mes);
    }

    public List<CategoriaResponse> findTotalAmountByCategoria(Integer ano, Integer mes) {
        return despesaRepository.findTotalAmountByCategoria(ano, mes);
    }
}