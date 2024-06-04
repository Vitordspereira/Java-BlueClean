package GlobalSolution.BlueClean.dto.alerta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroAlerta(

        @NotBlank
        @Size(max = 200)
        String mensagem,

        LocalDate dtHora,

        @NotBlank
        @Size(max = 20)
        String status
) {
}
