package GlobalSolution.BlueClean.repository.alerta;

import GlobalSolution.BlueClean.model.alerta.Alerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
