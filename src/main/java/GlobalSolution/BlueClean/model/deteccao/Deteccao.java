package GlobalSolution.BlueClean.model.deteccao;

import GlobalSolution.BlueClean.dto.deteccao.CadastroDeteccao;
import GlobalSolution.BlueClean.model.dispositivo.Dispositivo;
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
@Table(name = "TB_BC_DETECCAO_RESIDUO")
@EntityListeners(AuditingEntityListener.class)

public class Deteccao {

    @Id
    @GeneratedValue
    @Column(name = "ID_DETECCAO")
    private Long codigo;

    @Column(name = "DT_HR_DETECCAO", nullable = false)
    private LocalDate dtHora;

    @Column(name = "QT_RESIDUO", nullable = false)
    private Float quantidade;

    @Column(name = "TB_BC_TIPO_RESIUDO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoResiduo residuo;

    @ManyToOne
    @JoinColumn(name = "ID_DISPOSITIVO")
    private Dispositivo dispositivo;

    public Deteccao(CadastroDeteccao deteccao){
        dtHora = deteccao.dtHora();
        quantidade = deteccao.quantidade();
        residuo = deteccao.residuo();
    }

    public Deteccao(CadastroDeteccao deteccao, Dispositivo dispositivo){
        dtHora = deteccao.dtHora();
        quantidade = deteccao.quantidade();
        residuo = deteccao.residuo();
        this.dispositivo = dispositivo;
    }

    public void atualizarDados(CadastroDeteccao atualizacao){
        if (atualizacao.dtHora() != null)
            dtHora = atualizacao.dtHora();
        if (atualizacao.quantidade() != null)
            quantidade = atualizacao.quantidade();
        if (atualizacao.residuo() != null)
            residuo = atualizacao.residuo();
    }
}
