package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import br.com.solidtechsolutions.controlefinanciero.repositories.LancamentoRepository;
import br.com.solidtechsolutions.controlefinanciero.repositories.UsuarioRepository;
import br.com.solidtechsolutions.controlefinanciero.services.LancamentoService;
import br.com.solidtechsolutions.controlefinanciero.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = serviceUtils.toEntityUsuario(usuarioDTO);
        return serviceUtils.toDtoUsuario(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioDTO> buscarUsuario() {
        return serviceUtils.toDtoListUsuario(usuarioRepository.findAll());
    }
}
