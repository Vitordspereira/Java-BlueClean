package GlobalSolution.BlueClean.model.dispositivo;

import GlobalSolution.BlueClean.dto.dispositivo.CadastroDispositivo;
import GlobalSolution.BlueClean.model.deteccao.Deteccao;
import GlobalSolution.BlueClean.model.localizacao.Localizacao;
import GlobalSolution.BlueClean.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_BC_DISPOSITIVO_IOT")
public class Dispositivo {

    @Id
    @GeneratedValue
    @Column(name = "ID_DISPOSITIVO")
    private Long codigo;

    @Column(name = "TP_DISPOSITIVO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "LATITUDE", nullable = false)
    private Float latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private Float longitude;

    @Column(name = "STATUS_DISPOSITVO", nullable = false, length = 20)
    private String status;

    @OneToMany(mappedBy = "dispositivo", cascade = CascadeType.ALL)
    private List<Deteccao> deteccaos;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_LOCALIZACAO")
    private Localizacao localizacao;

    public Dispositivo(CadastroDispositivo dispositivo){
        tipo = dispositivo.tipo();
        latitude = dispositivo.latitude();
        longitude = dispositivo.longitude();
        status = dispositivo.status();
    }

    public Dispositivo(CadastroDispositivo dispositivo, Usuario usuario){
        tipo = dispositivo.tipo();
        latitude = dispositivo.latitude();
        longitude = dispositivo.longitude();
        status = dispositivo.status();
        this.usuario = usuario;
    }

    public Dispositivo(CadastroDispositivo dispositivo, Localizacao localizacao){
        tipo = dispositivo.tipo();
        latitude = dispositivo.latitude();
        longitude = dispositivo.longitude();
        status = dispositivo.status();
        this.localizacao = localizacao;
    }

    public void atualizarDados(CadastroDispositivo atualizacao){
        if (atualizacao.tipo() != null)
            tipo = atualizacao.tipo();
        if (atualizacao.latitude() != null)
            latitude = atualizacao.latitude();
        if (atualizacao.longitude() != null)
            longitude = atualizacao.longitude();
        if (atualizacao.status() != null)
            status = atualizacao.status();

    }
}
