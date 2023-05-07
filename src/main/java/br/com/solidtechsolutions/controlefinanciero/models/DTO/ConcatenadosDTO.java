package br.com.solidtechsolutions.controlefinanciero.models.DTO;

import br.com.solidtechsolutions.controlefinanciero.models.Categoria;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcatenadosDTO {
    private List<TipoGastoDTO> tipoGastos = new ArrayList<>();
    private List<CategoriaDTO> categorias= new ArrayList<>();
    private List<UsuarioDTO> usuarios= new ArrayList<>();
}
