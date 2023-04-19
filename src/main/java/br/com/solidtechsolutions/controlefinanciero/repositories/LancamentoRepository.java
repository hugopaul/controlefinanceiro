package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {

}
