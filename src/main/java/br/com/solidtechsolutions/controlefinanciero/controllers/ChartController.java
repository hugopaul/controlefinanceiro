package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.charts.GastosPorDia;
import br.com.solidtechsolutions.controlefinanciero.services.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/charts")
public class ChartController {

    private ChartService chartService;

    @Autowired
    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/buscarValorDiarioUltimos30")
    public ResponseEntity<List<GastosPorDia>> buscarValorDiarioUltimos30() {
        return chartService.buscarValorDiarioUltimos30();
    }
}