package GlobalSolution.BlueClean.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuario(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 100)
        String email,

        @NotBlank
        @Size(max = 100)
        String senha,

        @NotBlank
        @Size(max = 20)
        String tipo
) {
}
