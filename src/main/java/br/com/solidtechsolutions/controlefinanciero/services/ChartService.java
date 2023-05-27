package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.charts.Gasto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChartService {
    ResponseEntity<List<Gasto>> buscarValorDiarioUltimos30();

    ResponseEntity<List<Gasto>> buscarValorTotalUltimosMeses();
}
