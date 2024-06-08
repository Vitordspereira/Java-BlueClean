package GlobalSolution.BlueClean.controller.usuario;

import GlobalSolution.BlueClean.dto.alerta.CadastroAlerta;
import GlobalSolution.BlueClean.dto.alerta.DetalhesAlertaUsuario;
import GlobalSolution.BlueClean.dto.dispositivo.CadastroDispositivo;
import GlobalSolution.BlueClean.dto.dispositivo.DetalhesDispositivoUsuario;
import GlobalSolution.BlueClean.dto.usuario.CadastroUsuario;
import GlobalSolution.BlueClean.dto.usuario.DetalhesUsuario;
import GlobalSolution.BlueClean.model.alerta.Alerta;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;
import GlobalSolution.BlueClean.model.usuario.Usuario;
import GlobalSolution.BlueClean.repository.alerta.AlertaRepository;
import GlobalSolution.BlueClean.repository.dispositivo.DispositivoRepository;
import GlobalSolution.BlueClean.repository.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("usuarios")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;


    //Endpoint para pesquisar o usuario pelo nome
    @GetMapping("por-nome")
    public ResponseEntity<Page<DetalhesUsuario>> buscarNome(@RequestParam("nome")String nome, Pageable pageable){
        var lista = usuarioRepository.buscarPorNome(nome, pageable).map(DetalhesUsuario::new);
        return ResponseEntity.ok(lista);
    }

    //Endpoint para pesquisar o usuario pelo email
    @GetMapping("por-email")
    public ResponseEntity<Page<DetalhesUsuario>> buscarEmail(@RequestParam("email")String email, Pageable pageable){
        var lista = usuarioRepository.buscarPorEmail(email, pageable).map(DetalhesUsuario::new);
        return ResponseEntity.ok(lista);
    }

    //Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<DetalhesUsuario>> listar(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable)
                .stream().map(DetalhesUsuario::new).toList();
        return ResponseEntity.ok(lista);
    }

    //Listar usuário específico
    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuario> buscar(@PathVariable("id") Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuario(usuario));
    }

    //Cadastrar um novo usuário
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuario> cadastrar(@RequestBody CadastroUsuario usuarioPost,
                                                     UriComponentsBuilder uri){
        var usuario = new Usuario(usuarioPost);
        usuarioRepository.save(usuario);
        var url = uri.path("/usuarios/{id}").buildAndExpand(usuario.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuario(usuario));
    }

    //Post da tabela alerta
    @PostMapping("{id}/alertas")
    @Transactional
    public ResponseEntity<DetalhesAlertaUsuario> postAlertaUsuario(@PathVariable("id") Long id,
                                                                          @RequestBody @Valid CadastroAlerta dto,
                                                                          UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(id);
        var alerta = new Alerta(dto, usuario);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("alertas/{id}").buildAndExpand(alerta.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAlertaUsuario(alerta));
    }

    //Post da tabela dispositivo
    @PostMapping("{id}/dispositivos")
    @Transactional
    public ResponseEntity<DetalhesDispositivoUsuario> postDispositivoUsuario(@PathVariable("id") Long id,
                                                                        @RequestBody @Valid CadastroDispositivo dto,
                                                                        UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(id);
        var dispositivo = new Dispositivo(dto, usuario);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("dispositivos/{id}").buildAndExpand(dispositivo.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesDispositivoUsuario(dispositivo));
    }

    //Alterar usuário específico
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuario> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroUsuario usuarioPut){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarDados(usuarioPut);
        return ResponseEntity.ok(new DetalhesUsuario(usuario));
    }

    //Deletar usuário específico
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
