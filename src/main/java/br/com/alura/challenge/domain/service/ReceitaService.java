package br.com.alura.challenge.domain.service;

import br.com.alura.challenge.domain.entity.Receita;
import br.com.alura.challenge.domain.repository.ReceitaRepository;
import br.com.alura.challenge.dto.mapper.ReceitaMapper;
import br.com.alura.challenge.dto.request.ReceitaRequest;
import br.com.alura.challenge.dto.response.ReceitaResponse;
import br.com.alura.challenge.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    private final ReceitaMapper receitaMapper;

    public List<Receita> listaReceitas() {
        return receitaRepository.findAll();
    }

    public ReceitaResponse detalharReceita(Long idReceita) {
        Receita receita = receitaRepository.findById(idReceita)
                .orElseThrow(() -> new ResourceNotFoundException(("RECEITA_NAO_ENCONTRADA")));
        return receitaMapper.toEntityToResponse(receita);
    }

    public ReceitaResponse inserirReceita(ReceitaRequest receitaRequest) {
        Receita receita = receitaMapper.toRequestToEntity(receitaRequest);
        receita.setData(LocalDate.now());
        receitaRepository.save(receita);
        return receitaMapper.toEntityToResponse(receita);
    }

    public ReceitaResponse atualizarReceita(Long idReceita, ReceitaRequest receitaRequest) {
        Receita receita = receitaRepository.findById(idReceita)
                .orElseThrow(() -> new ResourceNotFoundException("RECEITA_NAO_ENCONTRADA"));

        receita.setDescricao(receitaRequest.getDescricao());
        receita.setValor(receitaRequest.getValor());
        receita.setData(LocalDate.now());

        return receitaMapper.toEntityToResponse(receita);
    }

    public void deletarReceita(Long idReceita) {
        Receita receita = receitaRepository.findById(idReceita)
                .orElseThrow(() -> new ResourceNotFoundException("RECEITA_NAO_ENCONTRADA"));
        receitaRepository.delete(receita);
    }

    public List<ReceitaResponse> buscarPorAnoMes(Integer ano, Integer mes) {
        return receitaMapper.toEntityListToResponse(receitaRepository.buscarPorAnoMes(ano, mes));
    }

    public ReceitaResponse buscarReceitaPorDescricao(String descricao) {
        Receita receita = receitaRepository.findByDescricao(descricao)
                .orElseThrow(() -> new ResourceNotFoundException(("RECEITA_NAO_ENCONTRADA")));
        return receitaMapper.toEntityToResponse(receita);
    }

    public Double findTotalAmountByMounth(Integer ano, Integer mes) {
        return receitaRepository.findTotalAmountByMounth(ano, mes);
    }
}
