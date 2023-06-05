package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.repositories.LancamentoRepository;
import br.com.solidtechsolutions.controlefinanciero.services.LancamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class LancamentoServiceImpl implements LancamentoService {

    private LancamentoRepository lancamentoRepository;

    private UtilsComponent serviceUtils;

    public LancamentoServiceImpl(LancamentoRepository lancamentoRepository,  UtilsComponent serviceUtils) {
        this.lancamentoRepository = lancamentoRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public LancamentoDTO salvarLancamento(LancamentoDTO lancamentoDTO) {
        Lancamento lancamento = serviceUtils.toEntityLancamento(lancamentoDTO);
        if (lancamento.getParcelado()){

        }
        return serviceUtils.toDtoLancamento(lancamentoRepository.save(lancamento));
    }

    @Override
    public List<LancamentoDTO> buscarLancamento() {
        return serviceUtils.toDtoListLancamento(lancamentoRepository.findAll());
    }

    @Override
    public Boolean deleteUserById(UUID id) {
        if (lancamentoRepository.existsById(id)) {
            lancamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
