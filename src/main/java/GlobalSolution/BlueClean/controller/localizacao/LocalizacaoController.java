package GlobalSolution.BlueClean.controller.localizacao;


import GlobalSolution.BlueClean.dto.dispositivo.CadastroDispositivo;
import GlobalSolution.BlueClean.dto.dispositivo.DetalhesDispositivoLocalizacao;
import GlobalSolution.BlueClean.dto.localizacao.CadastroLocalizacao;
import GlobalSolution.BlueClean.dto.localizacao.DetalhesLocalizacao;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;
import GlobalSolution.BlueClean.model.localizacao.Localizacao;
import GlobalSolution.BlueClean.repository.dispositivo.DispositivoRepository;
import GlobalSolution.BlueClean.repository.localizacao.LocalizacaoRepository;
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

@RequestMapping("localizacoes")
@Controller

public class LocalizacaoController {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;


    //Listar todas as localizações
    @GetMapping
    public ResponseEntity<List<DetalhesLocalizacao>> listar(Pageable pageable){
        var lista = localizacaoRepository.findAll(pageable)
                .stream().map(DetalhesLocalizacao::new).toList();
        return ResponseEntity.ok(lista);
    }

    //Listar localização específica
    @GetMapping("{id}")
    public ResponseEntity<DetalhesLocalizacao> buscar(@PathVariable("id") Long id){
        var localizacao = localizacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesLocalizacao(localizacao));
    }

    //Cadastrar uma nova localização
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesLocalizacao> cadastrar(@RequestBody CadastroLocalizacao localizacaoPost,
                                                    UriComponentsBuilder uri){
        var localizacao = new Localizacao(localizacaoPost);
        localizacaoRepository.save(localizacao);
        var url = uri.path("/localizacoes/{id}").buildAndExpand(localizacao.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesLocalizacao(localizacao));
    }

    //Post da tabela dispositivo
    @PostMapping("{id}/dispositivos")
    @Transactional
    public ResponseEntity<DetalhesDispositivoLocalizacao> postDispositivoLocalizacao(@PathVariable("id") Long id,
                                                                                 @RequestBody @Valid CadastroDispositivo dto,
                                                                                 UriComponentsBuilder uriBuilder){
        var localizacao = localizacaoRepository.getReferenceById(id);
        var dispositivo = new Dispositivo(dto, localizacao);
        localizacaoRepository.save(localizacao);
        var uri = uriBuilder.path("dispositivos/{id}").buildAndExpand(dispositivo.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesDispositivoLocalizacao(dispositivo));
    }

    //Alterar localização específica
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesLocalizacao> atualizar(@PathVariable("id") Long id,
                                                    @RequestBody CadastroLocalizacao localizacaoPut){
        var localizacao = localizacaoRepository.getReferenceById(id);
        localizacao.atualizarDados(localizacaoPut);
        return ResponseEntity.ok(new DetalhesLocalizacao(localizacao));
    }

    //Deletar localização específica
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        localizacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
