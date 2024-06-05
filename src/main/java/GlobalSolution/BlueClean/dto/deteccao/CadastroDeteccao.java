package GlobalSolution.BlueClean.dto.deteccao;

import GlobalSolution.BlueClean.model.deteccao.TipoResiduo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroDeteccao(

        @NotNull
        LocalDate dtHora,

        Float quantidade,
        TipoResiduo residuo) {
}
