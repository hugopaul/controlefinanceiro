package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.ConcatenadosDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import br.com.solidtechsolutions.controlefinanciero.repositories.CategoriaRepository;
import br.com.solidtechsolutions.controlefinanciero.repositories.TipoGastoRepository;
import br.com.solidtechsolutions.controlefinanciero.repositories.UsuarioRepository;
import br.com.solidtechsolutions.controlefinanciero.services.CategoriaService;
import br.com.solidtechsolutions.controlefinanciero.services.ConcatenadosService;
import br.com.solidtechsolutions.controlefinanciero.services.TipoGastoService;
import br.com.solidtechsolutions.controlefinanciero.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcatenadosServiceImpl implements ConcatenadosService {
    private UsuarioService usuarioService;
    private CategoriaService categoriaService;
    private TipoGastoService tipoGastoService;

    public ConcatenadosServiceImpl(UsuarioService usuarioService, CategoriaService categoriaService, TipoGastoService tipoGastoService) {
        this.usuarioService = usuarioService;
        this.categoriaService = categoriaService;
        this.tipoGastoService = tipoGastoService;
    }

    @Override
    public ConcatenadosDTO getAll() {
        ConcatenadosDTO concatenadosDTO = new ConcatenadosDTO();
        List<UsuarioDTO> usuarioDTOs = this.usuarioService.buscarUsuario();

        concatenadosDTO.setUsuarios(usuarioDTOs.stream().map(e -> e).collect(Collectors.toList()));

        List<TipoGastoDTO> tipoGastoDTOs = this.tipoGastoService.buscarTipoGasto();
        concatenadosDTO.setTipoGastos(tipoGastoDTOs.stream().map(e -> e).collect(Collectors.toList()));

        List<CategoriaDTO> categoriaDTOs =this.categoriaService.buscarCategoria();
        concatenadosDTO.setCategorias(categoriaDTOs.stream().map(e -> e).collect(Collectors.toList()));

        return concatenadosDTO;
    }
}
