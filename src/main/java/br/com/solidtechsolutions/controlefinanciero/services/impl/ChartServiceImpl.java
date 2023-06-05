package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.models.charts.Gasto;
import br.com.solidtechsolutions.controlefinanciero.repositories.GastoPorDiaRepository;
import br.com.solidtechsolutions.controlefinanciero.services.ChartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

@Service
public class ChartServiceImpl implements ChartService {

    private final GastoPorDiaRepository gastoPorDiaRepository;

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

    @Override
    public ResponseEntity<Gasto> buscarMediaDiariaUltimos30Dias() {
        Gasto resultado = gastoPorDiaRepository.buscarMediaDiariaUltimos30Dias();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#.00", symbols);
        String numeroFormatado = df.format(resultado.getTotalGasto());
        resultado.setTotalGasto(Double.valueOf(numeroFormatado.replace(",", ".")));
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Gasto> buscarMediaMensalUltimosMeses() {
        Gasto resultado = gastoPorDiaRepository.buscarMediaMensalUltimosMeses();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#.00", symbols);
        String numeroFormatado = df.format(resultado.getTotalGasto());
        resultado.setTotalGasto(Double.valueOf(numeroFormatado.replace(",", ".")));
        return ResponseEntity.ok(resultado);
    }


}
