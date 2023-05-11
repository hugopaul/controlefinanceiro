package br.com.solidtechsolutions.controlefinanciero.repositories;

import br.com.solidtechsolutions.controlefinanciero.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);


}
