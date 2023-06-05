package br.com.solidtechsolutions.controlefinanciero.controllers;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.services.TipoGastoService;
import br.com.solidtechsolutions.controlefinanciero.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        return usuarioService.salvarUsuario(usuarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarUsuarios() {

        return ResponseEntity.ok(usuarioService.buscarUsuario());
    }
    @DeleteMapping
    public ResponseEntity<Boolean> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        boolean deleted = usuarioService.deleteUserById(usuarioDTO.getId());
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
