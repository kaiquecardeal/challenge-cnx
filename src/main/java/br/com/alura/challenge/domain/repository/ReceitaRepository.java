package br.com.alura.challenge.domain.repository;

import br.com.alura.challenge.domain.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT d FROM Receita d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes")
    List<Receita> buscarPorAnoMes(Integer ano, Integer mes);

    Optional<Receita> findByDescricao(String descricao);

    @Query("SELECT SUM(r.valor) FROM Receita r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes")
    Double findTotalAmountByMounth(Integer ano, Integer mes);
}