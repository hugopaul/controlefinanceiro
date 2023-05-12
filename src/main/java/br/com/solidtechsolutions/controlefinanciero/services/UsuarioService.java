package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    ResponseEntity<UsuarioDTO> salvarUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> buscarUsuario();
}
