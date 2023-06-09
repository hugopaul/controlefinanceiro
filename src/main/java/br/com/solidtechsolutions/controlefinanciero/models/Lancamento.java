package br.com.solidtechsolutions.controlefinanciero.models;


import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_gasto_id")
    private TipoGasto tipoGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAtualizacao;

    // getters e setters
}
