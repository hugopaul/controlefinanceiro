package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.models.charts.GastosPorDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GastoPorDiaRepository extends JpaRepository<GastosPorDia, String> {


    @Query(value = "SELECT TO_CHAR(data_hora, 'DD/MM') as dia, SUM(valor) as total_gasto\n" +
            "FROM lancamento\n" +
            "WHERE data_hora >= CURRENT_DATE - INTERVAL '30 days'\n" +
            "GROUP BY dia\n" +
            "ORDER BY dia ASC", nativeQuery = true)
    List<GastosPorDia> buscarGastosPorDiaUltimos30Dias();

}
