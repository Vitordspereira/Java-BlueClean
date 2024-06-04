package GlobalSolution.BlueClean.dto.alerta;

import GlobalSolution.BlueClean.model.alerta.Alerta;

import java.time.LocalDate;

public record DetalhesAlerta(Long id, String mensagem, LocalDate dtHora, String status) {

    public DetalhesAlerta(Alerta alerta){
        this(alerta.getCodigo(), alerta.getMensagem(), alerta.getDtHora(), alerta.getStatus());
    }
}
