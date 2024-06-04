package GlobalSolution.BlueClean.repository.usuario;

import GlobalSolution.BlueClean.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
