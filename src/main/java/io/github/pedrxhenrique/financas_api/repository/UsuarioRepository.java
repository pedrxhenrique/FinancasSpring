package io.github.pedrxhenrique.financas_api.repository;


import io.github.pedrxhenrique.financas_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    List<Usuario> findByNome(String nome);
    List<Usuario> findByEmail(String email);

}
