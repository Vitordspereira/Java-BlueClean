package GlobalSolution.BlueClean.model.alerta;

import GlobalSolution.BlueClean.dto.alerta.CadastroAlerta;
import GlobalSolution.BlueClean.dto.usuario.CadastroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_BC_ALERTA")
@EntityListeners(AuditingEntityListener.class)

public class Alerta {

    @Id
    @GeneratedValue
    @Column(name = "ID_ALERTA")
    private Long codigo;

    @Column(name = "DS_MENSAGEM", nullable = false, length = 200)
    private String mensagem;

    @Column(name = "DT_HORA", nullable = false)
    private LocalDate dtHora;

    @Column(name = "ST_ALERTA", nullable = false, length = 20)
    private String status;

    public  Alerta(CadastroAlerta alerta){
        mensagem = alerta.mensagem();
        dtHora = alerta.dtHora();
        status = alerta.status();
    }

    public void atualizarDados(CadastroAlerta atualizacao){
        if (atualizacao.mensagem() != null)
            mensagem = atualizacao.mensagem();
        if (atualizacao.dtHora() != null)
            dtHora = atualizacao.dtHora();
        if (atualizacao.status() != null)
            status = atualizacao.status();
    }
}
