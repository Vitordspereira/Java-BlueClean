package GlobalSolution.BlueClean.model.usuario;

import GlobalSolution.BlueClean.dto.usuario.CadastroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_BC_USUARIO")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Long codigo;

    @Column(name = "NM_COMPLETO", nullable = false, length = 100)
    private String nome;

    @Column(name = "DS_EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "DS_SENHA", nullable = false, length = 100)
    private String senha;

    @Column(name = "TP_USUARIO", nullable = false, length = 20)
    private String tipo;

    public  Usuario(CadastroUsuario usuario){
        nome = usuario.nome();
        email = usuario.email();
        senha = usuario.senha();
        tipo = usuario.tipo();
    }

    public void atualizarDados(CadastroUsuario atualizacao){
        if (atualizacao.nome() != null)
            nome = atualizacao.nome();
        if (atualizacao.email() != null)
            email = atualizacao.email();
        if (atualizacao.senha() != null)
            senha = atualizacao.senha();
        if (atualizacao.tipo() != null)
            tipo = atualizacao.tipo();
    }
}
