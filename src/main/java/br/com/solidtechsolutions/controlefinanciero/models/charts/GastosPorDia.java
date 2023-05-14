package br.com.solidtechsolutions.controlefinanciero.models.charts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GastosPorDia {
    @Id
    private String dia;

    @Column(name = "total_gasto")
    private Double totalGasto;
}
