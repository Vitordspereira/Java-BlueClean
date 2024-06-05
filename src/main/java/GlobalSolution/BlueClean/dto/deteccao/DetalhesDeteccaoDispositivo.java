package GlobalSolution.BlueClean.dto.deteccao;

import GlobalSolution.BlueClean.dto.dispositivo.DetalhesDispositivo;
import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import GlobalSolution.BlueClean.model.deteccao.TipoResiduo;

import java.time.LocalDate;

public record DetalhesDeteccaoDispositivo(Long id, LocalDate dtHora, Float quantidade, TipoResiduo residuo,
                                          DetalhesDispositivo dispositivo) {

    public DetalhesDeteccaoDispositivo(Deteccao deteccao){
        this(deteccao.getCodigo(),deteccao.getDtHora(), deteccao.getQuantidade(), deteccao.getResiduo(),
                new DetalhesDispositivo(deteccao.getDispositivo()));
    }
}
