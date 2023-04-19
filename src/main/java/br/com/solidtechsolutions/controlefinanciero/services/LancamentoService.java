package br.com.solidtechsolutions.controlefinanciero.services;

import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;

import java.util.List;

public interface LancamentoService{
    LancamentoDTO salvarLancamento(LancamentoDTO lancamento);

    List<LancamentoDTO> buscarLancamento();

}
