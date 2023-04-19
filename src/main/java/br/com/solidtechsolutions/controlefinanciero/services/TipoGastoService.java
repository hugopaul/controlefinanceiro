package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;

import java.util.List;

public interface TipoGastoService {
    TipoGastoDTO salvarCategoria(TipoGastoDTO categoriaDTO);

    List<TipoGastoDTO> buscarTipoGasto();
}
