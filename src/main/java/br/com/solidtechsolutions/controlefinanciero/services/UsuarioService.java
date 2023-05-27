package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    ResponseEntity<UsuarioDTO> salvarUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> buscarUsuario();

    boolean deleteUserById(UUID id);
}
