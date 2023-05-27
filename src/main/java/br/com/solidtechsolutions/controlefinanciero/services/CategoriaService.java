package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {
    CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> buscarCategoria();

    boolean deleteUserById(UUID id);
}
