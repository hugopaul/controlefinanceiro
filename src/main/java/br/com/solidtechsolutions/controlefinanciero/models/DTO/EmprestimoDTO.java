package br.com.solidtechsolutions.controlefinanciero.models.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class EmprestimoDTO {

    private UUID id;

    private String nome;

    private String descricao;

    private String valor;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
