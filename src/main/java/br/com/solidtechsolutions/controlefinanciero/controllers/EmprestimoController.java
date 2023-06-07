package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.EmprestimoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Emprestimo;
import br.com.solidtechsolutions.controlefinanciero.services.EmprestimoService;
import br.com.solidtechsolutions.controlefinanciero.services.impl.EmprestimoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {
    private EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> salvarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {

        return ResponseEntity.ok(emprestimoService.salvarEmprestimoDTO(emprestimoDTO));
    }
    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> buscarEmprestimo() {

        return ResponseEntity.ok(emprestimoService.buscarTipoGasto());
    }
    @DeleteMapping
    public ResponseEntity<Boolean> deletarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        boolean deleted = emprestimoService.deleteUserById(emprestimoDTO.getId());
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
