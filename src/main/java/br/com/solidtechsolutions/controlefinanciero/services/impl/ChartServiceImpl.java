package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.models.charts.GastosPorDia;
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
    public ResponseEntity<List<GastosPorDia>> buscarValorDiarioUltimos30() {
        List<GastosPorDia> resultados = gastoPorDiaRepository.buscarGastosPorDiaUltimos30Dias();
        System.out.println(resultados);
        return ResponseEntity.ok(resultados);
    }


}
