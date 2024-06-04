package GlobalSolution.BlueClean.controller.usuario;

import GlobalSolution.BlueClean.dto.usuario.CadastroUsuario;
import GlobalSolution.BlueClean.dto.usuario.DetalhesUsuario;
import GlobalSolution.BlueClean.model.usuario.Usuario;
import GlobalSolution.BlueClean.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.util.List;

@RequestMapping("usuarios")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesUsuario>> listar(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable)
                .stream().map(DetalhesUsuario::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuario> buscar(@PathVariable("id") Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuario(usuario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuario> cadastrar(@RequestBody CadastroUsuario usuarioPost,
                                                     UriComponentsBuilder uri){
        var usuario = new Usuario(usuarioPost);
        usuarioRepository.save(usuario);
        var url = uri.path("/usuarios/{id}").buildAndExpand(usuario.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuario(usuario));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuario> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroUsuario usuarioPut){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarDados(usuarioPut);
        return ResponseEntity.ok(new DetalhesUsuario(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
