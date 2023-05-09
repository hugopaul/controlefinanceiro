package br.com.solidtechsolutions.controlefinanciero.components;

import br.com.solidtechsolutions.controlefinanciero.models.Categoria;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.CategoriaDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.LancamentoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.TipoGastoDTO;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.UsuarioDTO;
import br.com.solidtechsolutions.controlefinanciero.models.Lancamento;
import br.com.solidtechsolutions.controlefinanciero.models.TipoGasto;
import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtilsComponent {
    public Lancamento toEntityLancamento(LancamentoDTO dto) {
        Lancamento entity = new Lancamento();
        entity.setDescricao(dto.getDescricao());
        String valorSemCaracteres = dto.getValor().replace(",", "").replace(".", "");
        int index = valorSemCaracteres.length() - 2;

        String valor = valorSemCaracteres.substring(0, index) + "." + valorSemCaracteres.substring(index);
        entity.setValor(new BigDecimal(valor));

        entity.setDataHora(dto.getDataHora());
        entity.setCategoria(dto.getCategoria());
        entity.setTipoGasto(dto.getTipoGasto());
        entity.setUsuario(dto.getUsuario());
        entity.setQtdParcela(dto.getQtdParcela());
        entity.setParcelado(dto.getParcelado());
        entity.setDespesaFixa(dto.getDespesaFixa());

        return entity;
    }
    public Categoria toEntityCategoria(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        entity.setDescricao(dto.getDescricao());
        entity.setNome(dto.getNome());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setDataAtualizacao(dto.getDataAtualizacao());
        return entity;
    }
    public TipoGasto toEntityTipoGasto(TipoGastoDTO dto) {
        TipoGasto entity = new TipoGasto();
        entity.setDescricao(dto.getDescricao());
        entity.setNome(dto.getNome());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setDataAtualizacao(dto.getDataAtualizacao());
        return entity;
    }

    public CategoriaDTO toDtoCategoria(Categoria entity) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setNome(entity.getNome());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        return dto;
    }

    public LancamentoDTO toDtoLancamento(Lancamento entity) {
        LancamentoDTO dto = new LancamentoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setValor(String.valueOf(entity.getValor()));
        dto.setDataHora(entity.getDataHora());
        dto.setCategoria(entity.getCategoria());
        dto.setTipoGasto(entity.getTipoGasto());
        dto.setUsuario(entity.getUsuario());
        return dto;
    }

    public TipoGastoDTO toDtoTipoGasto(TipoGasto entity) {
        TipoGastoDTO dto = new TipoGastoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setNome(entity.getNome());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        return dto;
    }

    public Usuario toEntityUsuario(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataAtualizacao(dto.getDataAtualizacao());
        entity.setDataCriacao(LocalDateTime.now());
        //entity.setLancamentosGastos(dto.getLancamentosGastos());

        return entity;
    }

    public UsuarioDTO toDtoUsuario(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        //dto.setLancamentosGastos(entity.getLancamentosGastos());
        dto.setSenha(entity.getSenha());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setDataAtualizacao(entity.getDataAtualizacao());
        return dto;
    }

    public List<CategoriaDTO> toDtoListCategoria(List<Categoria> all) {
        return all.stream()
                .map(entity -> {
                    CategoriaDTO dto = new CategoriaDTO();
                    dto.setId(entity.getId());
                    dto.setDescricao(entity.getDescricao());
                    dto.setNome(entity.getNome());
                    dto.setDataCriacao(entity.getDataCriacao());
                    dto.setDataAtualizacao(entity.getDataAtualizacao());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<LancamentoDTO> toDtoListLancamento(List<Lancamento> all) {
        return all.stream()
                .map(entity -> {
                    LancamentoDTO dto = new LancamentoDTO();
                    dto.setId(entity.getId());
                    dto.setDescricao(entity.getDescricao());
                    dto.setTipoGasto(entity.getTipoGasto());
                    dto.setCategoria(entity.getCategoria());
                    dto.setUsuario(entity.getUsuario());
                    dto.setDataHora(entity.getDataHora());
                    dto.setValor(String.valueOf(entity.getValor()));
                    dto.setDataCriacao(entity.getDataCriacao());
                    dto.setDataAtualizacao(entity.getDataAtualizacao());
                    dto.setQtdParcela(entity.getQtdParcela());
                    dto.setParcelado(entity.getParcelado());
                    dto.setDespesaFixa(entity.getDespesaFixa());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<TipoGastoDTO> toDtoListTipoGasto(List<TipoGasto> all) {
        return all.stream()
                .map(entity -> {
                    TipoGastoDTO dto = new TipoGastoDTO();
                    dto.setId(entity.getId());
                    dto.setDescricao(entity.getDescricao());
                    dto.setNome(entity.getNome());
                    dto.setDataCriacao(entity.getDataCriacao());
                    dto.setDataAtualizacao(entity.getDataAtualizacao());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> toDtoListUsuario(List<Usuario> all) {
        return all.stream()
                .map(entity -> {
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setId(entity.getId());
                    dto.setSenha(entity.getSenha());
                    dto.setNome(entity.getNome());
                    dto.setEmail(entity.getEmail());
                    //dto.setLancamentosGastos(entity.getLancamentosGastos());
                    dto.setDataCriacao(entity.getDataCriacao());
                    dto.setDataAtualizacao(entity.getDataAtualizacao());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
