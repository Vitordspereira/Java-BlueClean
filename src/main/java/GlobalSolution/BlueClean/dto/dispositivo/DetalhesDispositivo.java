package GlobalSolution.BlueClean.dto.dispositivo;

import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;

public record DetalhesDispositivo(Long id, String tipo, Float latitude, Float longitude,
                                  String status) {

    public DetalhesDispositivo(Dispositivo dispositivo){
        this(dispositivo.getCodigo(), dispositivo.getTipo(), dispositivo.getLatitude(), dispositivo.getLongitude(),
                dispositivo.getStatus());
    }
}
