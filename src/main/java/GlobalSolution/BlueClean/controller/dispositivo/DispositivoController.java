package GlobalSolution.BlueClean.controller.dispositivo;

import GlobalSolution.BlueClean.dto.deteccao.CadastroDeteccao;
import GlobalSolution.BlueClean.dto.deteccao.DetalhesDeteccaoDispositivo;
import GlobalSolution.BlueClean.dto.dispositivo.CadastroDispositivo;
import GlobalSolution.BlueClean.dto.dispositivo.DetalhesDispositivo;
import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;
import GlobalSolution.BlueClean.repository.deteccao.DeteccaoRepository;
import GlobalSolution.BlueClean.repository.dispositivo.DispositivoRepository;
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

@RequestMapping("dispositivos")
@Controller

public class DispositivoController {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DeteccaoRepository deteccaoRepository;

    //Listar todos os dispositivos
    @GetMapping
    public ResponseEntity<List<DetalhesDispositivo>> listar(Pageable pageable){
        var lista = dispositivoRepository.findAll(pageable)
                .stream().map(DetalhesDispositivo::new).toList();
        return ResponseEntity.ok(lista);
    }

    //Listar dispositivo específico
    @GetMapping("{id}")
    public ResponseEntity<DetalhesDispositivo> buscar(@PathVariable("id") Long id){
        var dispositivo = dispositivoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesDispositivo(dispositivo));
    }

    //Cadastrar um dispositivo
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDispositivo> cadastrar(@RequestBody CadastroDispositivo dispositivoPost,
                                                         UriComponentsBuilder uri){
        var dispositivo = new Dispositivo(dispositivoPost);
        dispositivoRepository.save(dispositivo);
        var url = uri.path("/dispositivos/{id}").buildAndExpand(dispositivo.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesDispositivo(dispositivo));
    }

    //Post da tabela deteccao
    @PostMapping("{id}/deteccaos")
    @Transactional
    public ResponseEntity<DetalhesDeteccaoDispositivo> postDeteccaoDispositiivo(@PathVariable("id") Long id,
                                                                                @RequestBody @Valid CadastroDeteccao dto,
                                                                                UriComponentsBuilder uriBuilder){
        var dispositivo = dispositivoRepository.getReferenceById(id);
        var deteccao = new Deteccao(dto, dispositivo);
        dispositivoRepository.save(dispositivo);
        var uri = uriBuilder.path("deteccaos/{id}").buildAndExpand(deteccao.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesDeteccaoDispositivo(deteccao));
    }

    //Alterar dispositivo específico
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesDispositivo> atualizar(@PathVariable("id") Long id,
                                                         @RequestBody CadastroDispositivo dispositivoPut){
        var dispositivo = dispositivoRepository.getReferenceById(id);
        dispositivo.atualizarDados(dispositivoPut);
        return ResponseEntity.ok(new DetalhesDispositivo(dispositivo));
    }

    //Deletar dispositivo específico
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        dispositivoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
