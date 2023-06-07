package br.com.solidtechsolutions.controlefinanciero.components;

import br.com.solidtechsolutions.controlefinanciero.models.*;
import br.com.solidtechsolutions.controlefinanciero.models.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtilsComponent {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Lancamento toEntityLancamento(LancamentoDTO dto) {
        Lancamento entity = new Lancamento();
        entity.setDescricao(dto.getDescricao());

        String valorSemCaracteres = dto.getValor().replace(",", "").replace(".", "");
        int index = valorSemCaracteres.length() - 2;
        String valor = valorSemCaracteres.substring(0, index) + "." + valorSemCaracteres.substring(index);
        entity.setValor(new BigDecimal(valor));
        System.out.println(dto.getParcelado());
        if(dto.getParcelado()){
            String valorDaParcelaSemCaracteres = dto.getValorParcela().replace(",", "").replace(".", "");
            int indexx = valorDaParcelaSemCaracteres.length() - 2;
            String valorDaParcela = valorDaParcelaSemCaracteres.substring(0, indexx) + "." + valorDaParcelaSemCaracteres.substring(indexx);
            entity.setValorParcela(new BigDecimal(valorDaParcela));
        }
        entity.setDataHora(dto.getDataHora());
        entity.setCategoria(dto.getCategoria());
        entity.setTipoGasto(dto.getTipoGasto());

        entity.setUsuario(toEntityUsuario(dto.getUsuario(), false));
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
        dto.setUsuario(toDtoUsuario(entity.getUsuario()));
        if(entity.getParcelado()) {
            dto.setValorParcela(entity.getValorParcela().toString());
        }
        dto.setParcelado(entity.getParcelado());
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

    public Usuario toEntityUsuario(UsuarioDTO dto, boolean checkPass) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        if(checkPass){
            entity.setSenha(passwordEncoder.encode(dto.getSenha()));
        }
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
                    dto.setUsuario(toDtoUsuario(entity.getUsuario()));
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

    public EmprestimoDTO toDtoEmprestimo(Emprestimo save) {
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setDataAtualizacao(save.getDataAtualizacao());
        emprestimoDTO.setDataCriacao(save.getDataCriacao());
        emprestimoDTO.setId(save.getId());
        emprestimoDTO.setDescricao(save.getDescricao());
        emprestimoDTO.setValor(String.valueOf(save.getValor()));
        emprestimoDTO.setNome(save.getNome());
        return  emprestimoDTO;
    }

    public Emprestimo toEntityEmprestimo(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataAtualizacao(emprestimoDTO.getDataAtualizacao());
        emprestimo.setDataCriacao(emprestimoDTO.getDataCriacao());
        emprestimo.setNome(emprestimoDTO.getNome());
        emprestimo.setDescricao(emprestimoDTO.getDescricao());
        String valorSemCaracteres = emprestimoDTO.getValor().replace(",", "").replace(".", "");
        int index = valorSemCaracteres.length() - 2;
        String valor = valorSemCaracteres.substring(0, index) + "." + valorSemCaracteres.substring(index);
        emprestimo.setValor(new BigDecimal(valor));
        emprestimo.setId(emprestimoDTO.getId());
        return emprestimo;
    }

    public List<EmprestimoDTO> toDtoListEmprestimo(List<Emprestimo> all) {
        return all.stream()
                .map(entity -> {
                    EmprestimoDTO dto = new EmprestimoDTO();
                    dto.setId(entity.getId());
                    dto.setNome(entity.getNome());
                    dto.setDataCriacao(entity.getDataCriacao());
                    dto.setDataAtualizacao(entity.getDataAtualizacao());
                    dto.setValor(String.valueOf(entity.getValor()));
                    dto.setDescricao(entity.getDescricao());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
