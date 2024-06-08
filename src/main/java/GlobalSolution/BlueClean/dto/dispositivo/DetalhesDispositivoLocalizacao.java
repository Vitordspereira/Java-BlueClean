package GlobalSolution.BlueClean.dto.dispositivo;

import GlobalSolution.BlueClean.dto.localizacao.DetalhesLocalizacao;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;
import GlobalSolution.BlueClean.model.localizacao.Localizacao;

public record DetalhesDispositivoLocalizacao(Long id, String tipo, Float latitude, Float longitude,
                                             String status, DetalhesLocalizacao localizacao) {

    public DetalhesDispositivoLocalizacao(Dispositivo dispositivo){
        this(dispositivo.getCodigo(), dispositivo.getTipo(), dispositivo.getLatitude(), dispositivo.getLongitude(),
                dispositivo.getStatus(), new DetalhesLocalizacao(dispositivo.getLocalizacao()));
    }
}
