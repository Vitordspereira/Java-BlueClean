package GlobalSolution.BlueClean.dto.deteccao;

import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import GlobalSolution.BlueClean.model.deteccao.TipoResiduo;

import java.time.LocalDate;

public record DetalhesDeteccao(Long id, LocalDate dtHora, Float quantidade, TipoResiduo residuo) {

    public DetalhesDeteccao(Deteccao deteccao){
        this(deteccao.getCodigo(), deteccao.getDtHora(), deteccao.getQuantidade(), deteccao.getResiduo());
    }
}
