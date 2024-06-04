package GlobalSolution.BlueClean.model.localizacao;

import GlobalSolution.BlueClean.dto.localizacao.CadastroLocalizacao;
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
@Table(name = "TB_BC_LOCALIZACAO")
@EntityListeners(AuditingEntityListener.class)

public class Localizacao {

    @Id
    @GeneratedValue
    @Column(name = "ID_LOCALIZACAO")
    private Long codigo;

    @Column(name = "NM_LOCALIZACAO", nullable = false, length = 100)
    private String nome;

    @Column(name = "DS_LOCALIZACAO", length = 200)
    private String descricao;

    public Localizacao(CadastroLocalizacao localizacao){
        nome = localizacao.nome();
        descricao = localizacao.descricao();
    }

    public void atualizarDados(CadastroLocalizacao atualizacao){
        if (atualizacao.nome() != null)
            nome = atualizacao.nome();
        if (atualizacao.descricao() != null)
            descricao = atualizacao.descricao();
    }
}
