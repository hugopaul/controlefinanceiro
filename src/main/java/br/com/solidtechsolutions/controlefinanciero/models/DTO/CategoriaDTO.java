package br.com.solidtechsolutions.controlefinanciero.models.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private UUID id;

    private String nome;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
