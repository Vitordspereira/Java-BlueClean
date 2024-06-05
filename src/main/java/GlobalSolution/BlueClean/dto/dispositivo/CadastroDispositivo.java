package GlobalSolution.BlueClean.dto.dispositivo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroDispositivo(

        @NotBlank
        @Size(max = 50)
        String tipo,

        Float latitude,

        Float longitude,

        @NotBlank
        @Size(max = 20)
        String status
) {
}
