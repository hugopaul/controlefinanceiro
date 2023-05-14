package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.charts.GastosPorDia;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChartService {
    ResponseEntity<List<GastosPorDia>> buscarValorDiarioUltimos30();
}
