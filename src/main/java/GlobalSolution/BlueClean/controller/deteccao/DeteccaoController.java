package GlobalSolution.BlueClean.controller.deteccao;

import GlobalSolution.BlueClean.dto.deteccao.CadastroDeteccao;
import GlobalSolution.BlueClean.dto.deteccao.DetalhesDeteccao;
import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import GlobalSolution.BlueClean.repository.deteccao.DeteccaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("deteccaos")
@Controller

public class DeteccaoController {

    @Autowired
    private DeteccaoRepository deteccaoRepository;

    //Listar todas as detecções
    @GetMapping
    public ResponseEntity<List<DetalhesDeteccao>> listar(Pageable pageable){
        var lista = deteccaoRepository.findAll(pageable)
                .stream().map(DetalhesDeteccao::new).toList();
        return ResponseEntity.ok(lista);
    }

    //listar detecção específica
    @GetMapping("{id}")
    public ResponseEntity<DetalhesDeteccao> buscar(@PathVariable("id") Long id){
        var deteccao = deteccaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesDeteccao(deteccao));
    }

    //Cadastrar uma detecção
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDeteccao> cadastrar(@RequestBody CadastroDeteccao deteccaoPost,
                                                    UriComponentsBuilder uri){
        var deteccao = new Deteccao(deteccaoPost);
        deteccaoRepository.save(deteccao);
        var url = uri.path("/deteccoes/{id}").buildAndExpand(deteccao.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesDeteccao(deteccao));
    }

    //Alterar detecção específica
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesDeteccao> atualizar(@PathVariable("id") Long id,
                                                    @RequestBody CadastroDeteccao deteccaoPut){
        var deteccao = deteccaoRepository.getReferenceById(id);
        deteccao.atualizarDados(deteccaoPut);
        return ResponseEntity.ok(new DetalhesDeteccao(deteccao));
    }

    //Deletar detecção específica
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        deteccaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
