package br.com.solidtechsolutions.controlefinanciero.services.impl;

import br.com.solidtechsolutions.controlefinanciero.components.UtilsComponent;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.EmprestimoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Emprestimo;
import br.com.solidtechsolutions.controlefinanciero.repositories.EmprestimoRepository;
import br.com.solidtechsolutions.controlefinanciero.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private EmprestimoRepository emprestimoRepository;

    private UtilsComponent serviceUtils;
    @Autowired
    public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository, UtilsComponent serviceUtils) {
        this.emprestimoRepository = emprestimoRepository;
        this.serviceUtils = serviceUtils;
    }

    @Override
    public EmprestimoDTO salvarEmprestimoDTO(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = serviceUtils.toEntityEmprestimo(emprestimoDTO);
        return serviceUtils.toDtoEmprestimo(emprestimoRepository.save(emprestimo));
    }

    @Override
    public List<EmprestimoDTO> buscarTipoGasto() {
        return serviceUtils.toDtoListEmprestimo(emprestimoRepository.findAll());
    }

    @Override
    public boolean deleteUserById(UUID id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
