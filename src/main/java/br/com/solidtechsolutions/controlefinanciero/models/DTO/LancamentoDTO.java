package br.com.solidtechsolutions.controlefinanciero.models.DTO;

import br.com.solidtechsolutions.controlefinanciero.models.Categoria;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {
    private UUID id;
    private String descricao;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private Categoria categoria;
    private TipoGasto tipoGasto;
    private Usuario usuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
