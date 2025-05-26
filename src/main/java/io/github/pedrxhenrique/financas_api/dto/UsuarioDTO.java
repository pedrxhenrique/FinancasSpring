package io.github.pedrxhenrique.financas_api.dto;


import io.github.pedrxhenrique.financas_api.model.Usuario;

import java.util.UUID;

public record UsuarioDTO(UUID id, String nome, String email, String senha) {

    public Usuario mapearParaUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        return usuario;
    }
}
