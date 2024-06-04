package GlobalSolution.BlueClean.controller.alerta;

import GlobalSolution.BlueClean.dto.alerta.CadastroAlerta;
import GlobalSolution.BlueClean.dto.alerta.DetalhesAlerta;
import GlobalSolution.BlueClean.model.alerta.Alerta;
import GlobalSolution.BlueClean.repository.alerta.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.util.List;

@RequestMapping("alertas")
@Controller

public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesAlerta>> listar(Pageable pageable){
        var lista = alertaRepository.findAll(pageable)
                .stream().map(DetalhesAlerta::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesAlerta> buscar(@PathVariable("id") Long id){
        var alerta = alertaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesAlerta(alerta));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesAlerta> cadastrar(@RequestBody CadastroAlerta alertaPost,
                                                     UriComponentsBuilder uri){
        var alerta = new Alerta(alertaPost);
        alertaRepository.save(alerta);
        var url = uri.path("/alertas/{id}").buildAndExpand(alerta.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesAlerta(alerta));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesAlerta> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroAlerta alertaPut){
        var alerta = alertaRepository.getReferenceById(id);
        alerta.atualizarDados(alertaPut);
        return ResponseEntity.ok(new DetalhesAlerta(alerta));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        alertaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
