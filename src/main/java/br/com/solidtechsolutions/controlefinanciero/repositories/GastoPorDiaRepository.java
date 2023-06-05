package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.charts.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GastoPorDiaRepository extends JpaRepository<Gasto, String> {


    @Query(value = "SELECT TO_CHAR(data_hora, 'DD/MM') as dia_mes_ano, SUM(valor) as total_gasto\n" +
            "FROM lancamento\n" +
            "WHERE data_hora >= CURRENT_DATE - INTERVAL '30 days'\n" +
            "GROUP BY dia_mes_ano\n" +
            "ORDER BY dia_mes_ano ASC", nativeQuery = true)
    List<Gasto> buscarGastosPorDiaUltimos30Dias();

    @Query(value = "SELECT TO_CHAR(data_hora, 'MM/YYYY') as dia_mes_ano, SUM(valor) as total_gasto\n" +
            "FROM lancamento\n" +
            "WHERE data_hora >= CURRENT_DATE - INTERVAL '12 months'\n" +
            "GROUP BY dia_mes_ano\n" +
            "ORDER BY dia_mes_ano ASC", nativeQuery = true)
    List<Gasto> buscarValorTotalUltimosMeses();

    @Query(value = "SELECT 'Média diária ultimos 30 dias' as dia_mes_ano,\n" +
            "AVG(valor) AS total_gasto\n" +
            "FROM lancamento\n" +
            "WHERE data_hora >= CURRENT_DATE - INTERVAL '30 days'", nativeQuery = true)
    Gasto buscarMediaDiariaUltimos30Dias();

    @Query(value = "SELECT 'Média mensal ultimos 12 meses' as dia_mes_ano,\n" +
            "AVG(valor) AS total_gasto\n" +
            "FROM lancamento\n" +
            "WHERE data_hora >= CURRENT_DATE - INTERVAL '12 months'", nativeQuery = true)
    Gasto buscarMediaMensalUltimosMeses();
}
