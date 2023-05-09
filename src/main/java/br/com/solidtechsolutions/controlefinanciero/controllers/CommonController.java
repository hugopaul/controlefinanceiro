package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.ConcatenadosDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.services.ConcatenadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/common", produces = "application/json")
public class CommonController {

    private ConcatenadosService concatenadosService;

    @Autowired
    public CommonController(ConcatenadosService concatenadosService) {
        this.concatenadosService = concatenadosService;
    }

    @GetMapping
    public ResponseEntity<ConcatenadosDTO> buscarConcatenados() {
        ConcatenadosDTO concatenadosDTO = concatenadosService.getAll();
        return ResponseEntity.ok(concatenadosDTO);
    }
}
