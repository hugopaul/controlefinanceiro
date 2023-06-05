package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.ok(categoriaService.salvarCategoria(categoriaDTO));
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias() {

        return ResponseEntity.ok(categoriaService.buscarCategoria());
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        boolean deleted = categoriaService.deleteUserById(categoriaDTO.getId());
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
