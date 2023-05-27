package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.Categoria;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import br.com.solidtechsolutions.controlefinanciero.repositories.CategoriaRepository;
import br.com.solidtechsolutions.controlefinanciero.repositories.TipoGastoRepository;
import br.com.solidtechsolutions.controlefinanciero.services.CategoriaService;
import br.com.solidtechsolutions.controlefinanciero.services.TipoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoGastoServiceImpl implements TipoGastoService {


    private TipoGastoRepository tipoGastoRepository;

    private UtilsComponent serviceUtils;
    @Autowired
    public TipoGastoServiceImpl(TipoGastoRepository tipoGastoRepository, UtilsComponent serviceUtils) {
        this.tipoGastoRepository = tipoGastoRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public TipoGastoDTO salvarCategoria(TipoGastoDTO tipoGastoDTO) {
        TipoGasto tipoGasto = serviceUtils.toEntityTipoGasto(tipoGastoDTO);
        return serviceUtils.toDtoTipoGasto(tipoGastoRepository.save(tipoGasto));
    }

    @Override
    public List<TipoGastoDTO> buscarTipoGasto() {
        return serviceUtils.toDtoListTipoGasto(tipoGastoRepository.findAll());
    }

    @Override
    public boolean deleteUserById(UUID id) {
        if (tipoGastoRepository.existsById(id)) {
            tipoGastoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
