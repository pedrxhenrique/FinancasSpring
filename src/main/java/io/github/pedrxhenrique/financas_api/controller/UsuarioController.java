package io.github.pedrxhenrique.financas_api.controller;

import io.github.pedrxhenrique.financas_api.dto.UsuarioDTO;
import io.github.pedrxhenrique.financas_api.model.Usuario;
import io.github.pedrxhenrique.financas_api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/financas")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        var user = usuarioDTO.mapearParaUsuario();
        usuarioService.salvar(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizar(@PathVariable("id") String id, @RequestBody UsuarioDTO dto) {
        var idAutor = UUID.fromString(id);
        Optional<Usuario> autorOptional = usuarioService.buscarPorId(idAutor);
        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var autor = autorOptional.get();
        autor.setNome(dto.nome());
        autor.setEmail(dto.email());
        autor.setSenha(dto.senha());
        usuarioService.atualizar(autor);
        return ResponseEntity.noContent().build();
    }

}
