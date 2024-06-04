package GlobalSolution.BlueClean.repository.localizacao;

import GlobalSolution.BlueClean.model.localizacao.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository <Localizacao, Long> {
}
