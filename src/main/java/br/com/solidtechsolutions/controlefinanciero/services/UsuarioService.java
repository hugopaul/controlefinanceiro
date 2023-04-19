package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> buscarUsuario();
}
