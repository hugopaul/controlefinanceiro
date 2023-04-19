package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.Categoria;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.repositories.CategoriaRepository;
import br.com.solidtechsolutions.controlefinanciero.repositories.LancamentoRepository;
import br.com.solidtechsolutions.controlefinanciero.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private CategoriaRepository categoriaRepository;

    private UtilsComponent serviceUtils;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, UtilsComponent serviceUtils) {
        this.categoriaRepository = categoriaRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = serviceUtils.toEntityCategoria(categoriaDTO);
        return serviceUtils.toDtoCategoria(categoriaRepository.save(categoria));
    }

    @Override
    public List<CategoriaDTO> buscarCategoria() {
        return serviceUtils.toDtoListCategoria(categoriaRepository.findAll());
    }
}
