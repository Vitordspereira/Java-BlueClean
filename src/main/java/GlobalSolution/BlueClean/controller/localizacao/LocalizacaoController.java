package GlobalSolution.BlueClean.controller.localizacao;

import GlobalSolution.BlueClean.dto.alerta.CadastroAlerta;
import GlobalSolution.BlueClean.dto.alerta.DetalhesAlerta;
import GlobalSolution.BlueClean.dto.localizacao.CadastroLocalizacao;
import GlobalSolution.BlueClean.dto.localizacao.DetalhesLocalizacao;
import GlobalSolution.BlueClean.model.alerta.Alerta;
import GlobalSolution.BlueClean.model.localizacao.Localizacao;
import GlobalSolution.BlueClean.repository.localizacao.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.util.List;

@RequestMapping("localizacoes")
@Controller

public class LocalizacaoController {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesLocalizacao>> listar(Pageable pageable){
        var lista = localizacaoRepository.findAll(pageable)
                .stream().map(DetalhesLocalizacao::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesLocalizacao> buscar(@PathVariable("id") Long id){
        var localizacao = localizacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesLocalizacao(localizacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesLocalizacao> cadastrar(@RequestBody CadastroLocalizacao localizacaoPost,
                                                    UriComponentsBuilder uri){
        var localizacao = new Localizacao(localizacaoPost);
        localizacaoRepository.save(localizacao);
        var url = uri.path("/localizacoes/{id}").buildAndExpand(localizacao.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesLocalizacao(localizacao));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesLocalizacao> atualizar(@PathVariable("id") Long id,
                                                    @RequestBody CadastroLocalizacao localizacaoPut){
        var localizacao = localizacaoRepository.getReferenceById(id);
        localizacao.atualizarDados(localizacaoPut);
        return ResponseEntity.ok(new DetalhesLocalizacao(localizacao));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        localizacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
