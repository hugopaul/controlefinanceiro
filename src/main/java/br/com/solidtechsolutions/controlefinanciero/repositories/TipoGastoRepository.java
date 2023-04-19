package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoGastoRepository extends JpaRepository<TipoGasto, UUID> {

}
