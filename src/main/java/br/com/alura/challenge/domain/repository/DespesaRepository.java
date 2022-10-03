package br.com.alura.challenge.domain.repository;

import br.com.alura.challenge.domain.entity.Despesa;
import br.com.alura.challenge.dto.response.CategoriaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {


    @Query("SELECT d FROM Despesa d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes")
    List<Despesa> buscarPorAnoMes(Integer ano, Integer mes);

    Optional<Despesa> findByDescricao(String descricao);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes")
    Double findTotalAmountByMounth(Integer ano, Integer mes);

    @Query("SELECT NEW br.com.alura.challenge.dto.response.CategoriaResponse(d.categoria, SUM(d.valor)) FROM Despesa d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes GROUP BY d.categoria")
    List<CategoriaResponse> findTotalAmountByCategoria(Integer ano, Integer mes);
}