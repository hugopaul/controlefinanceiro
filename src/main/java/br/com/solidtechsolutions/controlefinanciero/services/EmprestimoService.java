package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.EmprestimoDTO;

import java.util.List;
import java.util.UUID;

public interface EmprestimoService {
    EmprestimoDTO salvarEmprestimoDTO(EmprestimoDTO emprestimoDTO);

    List<EmprestimoDTO> buscarTipoGasto();

    boolean deleteUserById(UUID id);
}
