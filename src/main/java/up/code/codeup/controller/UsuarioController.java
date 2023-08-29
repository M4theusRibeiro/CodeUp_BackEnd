package up.code.codeup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import up.code.codeup.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private List<Usuario> usuariosCadastrados = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        if (!usuariosCadastrados.isEmpty()) {
            return ResponseEntity.status(200).body(usuariosCadastrados);
        }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novoUsuario) {
        if (novoUsuario != null) {
            usuariosCadastrados.add(novoUsuario);
            return ResponseEntity.status(200).body(novoUsuario);
        }
        return ResponseEntity.status(400).build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int indice, @RequestBody Usuario usuarioAtualizado) {
        if (indice >= 0 && indice < usuariosCadastrados.size() && usuarioAtualizado != null) {
            usuariosCadastrados.set(indice, usuarioAtualizado);
            return ResponseEntity.status(200).body(usuarioAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Usuario> deletar(@PathVariable int indice){
        if(indice >= 0 && indice < usuariosCadastrados.size()){
            usuariosCadastrados.remove(indice);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> getPorId(@PathVariable int indice) {
        if (indice >= 0 && indice < usuariosCadastrados.size()) {
            return ResponseEntity.status(200).body(usuariosCadastrados.get(indice));
        }
        return ResponseEntity.status(404).build();
    }
}