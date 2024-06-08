package GlobalSolution.BlueClean.repository.localizacao;

import GlobalSolution.BlueClean.model.localizacao.Localizacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}
