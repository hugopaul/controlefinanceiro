package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.repositories.LancamentoRepository;
import br.com.solidtechsolutions.controlefinanciero.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LancamentoServiceImpl implements LancamentoService {



    private LancamentoRepository lancamentoRepository;

    private UtilsComponent serviceUtils;
    @Autowired
    public LancamentoServiceImpl(LancamentoRepository lancamentoRepository, UtilsComponent serviceUtils) {
        this.lancamentoRepository = lancamentoRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public LancamentoDTO salvarLancamento(LancamentoDTO lancamentoDTO) {
        Lancamento lancamento = serviceUtils.toEntityLancamento(lancamentoDTO);
        return serviceUtils.toDtoLancamento(lancamentoRepository.save(lancamento));
    }

    @Override
    public List<LancamentoDTO> buscarLancamento() {
        return serviceUtils.toDtoListLancamento(lancamentoRepository.findAll());
    }
}
