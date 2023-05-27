package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.models.charts.Gasto;
import br.com.solidtechsolutions.controlefinanciero.repositories.GastoPorDiaRepository;
import br.com.solidtechsolutions.controlefinanciero.services.ChartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    private GastoPorDiaRepository gastoPorDiaRepository;

    public ChartServiceImpl(GastoPorDiaRepository gastoPorDiaRepository) {
        this.gastoPorDiaRepository = gastoPorDiaRepository;
    }

    @Override
    public ResponseEntity<List<Gasto>> buscarValorDiarioUltimos30() {
        List<Gasto> resultados = gastoPorDiaRepository.buscarGastosPorDiaUltimos30Dias();
        return ResponseEntity.ok(resultados);
    }

    @Override
    public ResponseEntity<List<Gasto>> buscarValorTotalUltimosMeses() {
        List<Gasto> resultados = gastoPorDiaRepository.buscarValorTotalUltimosMeses();
        return ResponseEntity.ok(resultados);
    }


}
