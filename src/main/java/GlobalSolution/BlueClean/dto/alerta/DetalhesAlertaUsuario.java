package GlobalSolution.BlueClean.dto.alerta;

import GlobalSolution.BlueClean.dto.usuario.DetalhesUsuario;
import GlobalSolution.BlueClean.model.alerta.Alerta;

import java.time.LocalDate;

public record DetalhesAlertaUsuario(Long id, String mensagem, LocalDate dtHora, String status,
                                    DetalhesUsuario usuario) {

    public DetalhesAlertaUsuario(Alerta alerta){
        this(alerta.getCodigo(), alerta.getMensagem(), alerta.getDtHora(), alerta.getStatus(),
                new DetalhesUsuario(alerta.getUsuario()));
    }
}
