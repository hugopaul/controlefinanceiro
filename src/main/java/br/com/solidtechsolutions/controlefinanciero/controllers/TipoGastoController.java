package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.services.CategoriaService;
import br.com.solidtechsolutions.controlefinanciero.services.TipoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipogastos")
public class TipoGastoController {

    private TipoGastoService tipoGastoService;

    @Autowired
    public TipoGastoController(TipoGastoService tipoGastoService) {
        this.tipoGastoService = tipoGastoService;
    }

    @PostMapping
    public ResponseEntity<TipoGastoDTO> salvarTipoGasto(@RequestBody TipoGastoDTO tipoGastoDTO) {

        return ResponseEntity.ok(tipoGastoService.salvarCategoria(tipoGastoDTO));
    }
    @GetMapping
    public ResponseEntity<List<TipoGastoDTO>> buscarTipoGastos() {

        return ResponseEntity.ok(tipoGastoService.buscarTipoGasto());
    }
    @DeleteMapping
    public ResponseEntity<Boolean> deletarTipoGasto(@RequestBody TipoGastoDTO tipoGastoDTO) {
        boolean deleted = tipoGastoService.deleteUserById(tipoGastoDTO.getId());
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
