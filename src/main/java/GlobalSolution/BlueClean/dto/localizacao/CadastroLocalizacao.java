package GlobalSolution.BlueClean.dto.localizacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroLocalizacao(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 200)
        String descricao
) {
}
