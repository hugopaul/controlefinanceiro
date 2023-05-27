package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;

import java.util.List;
import java.util.UUID;

public interface LancamentoService{
    LancamentoDTO salvarLancamento(LancamentoDTO lancamento);

    List<LancamentoDTO> buscarLancamento();

    Boolean deleteUserById(UUID id);
}
