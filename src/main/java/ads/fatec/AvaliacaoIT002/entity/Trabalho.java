package ads.fatec.AvaliacaoIT002.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tra_trabalho")
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private Long id;

    @Column(name = "tra_titulo", unique = true, nullable = false, length = 100)
    private String titulo;

    @Column(name = "tra_data_hora_entrega", nullable = false)
    private LocalDateTime dataHoraEntrega;

    @Column(name = "tra_descricao", length = 200)
    private String descricao;

    @Column(name = "tra_grupo", nullable = false, length = 20)
    private String grupo;

    @Column(name = "tra_nota")
    private Integer nota;

    @Column(name = "tra_justificativa", length = 100)
    private String justificativa;

    public Trabalho() {}

    public Trabalho(String titulo, LocalDateTime dataHoraEntrega, String grupo, Integer nota, String justificativa) {
        this();
        this.titulo = titulo;
        this.dataHoraEntrega = dataHoraEntrega;
        this.grupo = grupo;
        this.nota = nota;
        this.justificativa = justificativa;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}