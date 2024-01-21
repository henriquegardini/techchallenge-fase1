package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer apartamento;
    private Integer andar;
    private String torre;
    @CreationTimestamp
    private LocalDate inclusao;
    private LocalDate expiracao;
    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Visitante visitante;

    public Visita(Long id, Integer apartamento, Integer andar, String torre, LocalDate inclusao, LocalDate expiracao) {
        this.id = id;
        this.apartamento = apartamento;
        this.andar = andar;
        this.torre = torre;
        this.inclusao = inclusao;
        this.expiracao = expiracao;
    }
    public Visita() {

    }

    public Visita(Integer apartamento, Integer andar, String torre, LocalDate expiracao) {
        this.apartamento = apartamento;
        this.andar = andar;
        this.torre = torre;
        this.expiracao = expiracao;
    }

    public Long getId() {
        return id;
    }

    public Integer getApartamento() {
        return apartamento;
    }

    public void setApartamento(Integer apartamento) {
        this.apartamento = apartamento;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public LocalDate getInclusao() {
        return inclusao;
    }

    public void setInclusao(LocalDate inclusao) {
        this.inclusao = inclusao;
    }

    public LocalDate getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(LocalDate expiracao) {
        this.expiracao = expiracao;
    }

    public void setVisitante(Visitante visitante) { this.visitante = visitante; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visita visita)) return false;
        return getId().equals(visita.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Visita{" +
                "id=" + id +
                ", apartamento=" + apartamento +
                ", torre='" + torre + '\'' +
                ", inclusao=" + inclusao +
                ", expiracao=" + expiracao +
                '}';
    }


}
