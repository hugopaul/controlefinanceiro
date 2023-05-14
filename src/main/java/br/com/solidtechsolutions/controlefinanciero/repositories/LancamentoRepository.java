package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.charts.GastosPorDia;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LancamentoRepository extends JpaRepository<Lancamento, UUID> {


}
