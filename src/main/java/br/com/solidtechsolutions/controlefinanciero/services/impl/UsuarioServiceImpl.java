package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import br.com.solidtechsolutions.controlefinanciero.repositories.UsuarioRepository;
import br.com.solidtechsolutions.controlefinanciero.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UsuarioServiceImpl implements UsuarioService {



    private UsuarioRepository usuarioRepository;

    private UtilsComponent serviceUtils;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UtilsComponent serviceUtils) {
        this.usuarioRepository = usuarioRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public ResponseEntity<UsuarioDTO> salvarUsuario(UsuarioDTO usuarioDTO) {
        try{

            Usuario usuario = serviceUtils.toEntityUsuario(usuarioDTO, true);
            UsuarioDTO usuarioDTOreturn = serviceUtils.toDtoUsuario(usuarioRepository.save(usuario));
            return ResponseEntity.ok().body(usuarioDTOreturn);
        } catch (Exception e){

            return ResponseEntity.badRequest().build();

        }

    }

    @Override
    public List<UsuarioDTO> buscarUsuario() {
        return serviceUtils.toDtoListUsuario(usuarioRepository.findAll());
    }

    @Override
    public boolean deleteUserById(UUID id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
