package GlobalSolution.BlueClean.repository.deteccao;

import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DeteccaoRepository extends JpaRepository<Deteccao, Long> {
}
