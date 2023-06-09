package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {


    private LancamentoService lancamentoService;

    @Autowired
    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @PostMapping
    public ResponseEntity<LancamentoDTO> salvarLancamento(@RequestBody LancamentoDTO lancamentoDTO) {

        return ResponseEntity.ok(lancamentoService.salvarLancamento(lancamentoDTO));
    }
    @GetMapping
    public ResponseEntity<List<LancamentoDTO>> buscarLancamento() {

        return ResponseEntity.ok(lancamentoService.buscarLancamento());
    }
}
