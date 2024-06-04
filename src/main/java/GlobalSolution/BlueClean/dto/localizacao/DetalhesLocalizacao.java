package GlobalSolution.BlueClean.dto.localizacao;

import GlobalSolution.BlueClean.model.localizacao.Localizacao;

public record DetalhesLocalizacao(Long id, String nome, String descricao) {

    public DetalhesLocalizacao(Localizacao localizacao){
        this(localizacao.getCodigo(), localizacao.getNome(), localizacao.getDescricao());
    }
}
