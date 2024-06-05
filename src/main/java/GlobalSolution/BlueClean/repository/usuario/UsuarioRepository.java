package GlobalSolution.BlueClean.repository.usuario;

import GlobalSolution.BlueClean.model.usuario.Usuario;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
