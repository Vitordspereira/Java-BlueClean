package GlobalSolution.BlueClean.dto.dispositivo;

import GlobalSolution.BlueClean.dto.usuario.DetalhesUsuario;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;

public record DetalhesDispositivoUsuario(Long id, String tipo, Float latitude, Float longitude,
                                         String status, DetalhesUsuario usuario) {

    public DetalhesDispositivoUsuario(Dispositivo dispositivo){
        this(dispositivo.getCodigo(), dispositivo.getTipo(), dispositivo.getLatitude(), dispositivo.getLongitude(),
                dispositivo.getStatus(), new DetalhesUsuario(dispositivo.getUsuario()));
    }
}
