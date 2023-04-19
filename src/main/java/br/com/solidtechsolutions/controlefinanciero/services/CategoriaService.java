package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> buscarCategoria();
}
