package br.com.solidtechsolutions.controlefinanciero.models.DTO;

import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Lancamento> lancamentosGastos;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
