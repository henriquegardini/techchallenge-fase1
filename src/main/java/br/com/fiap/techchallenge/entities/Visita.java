package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer numeroApartamento;
    private String nomeTorre;
    @CreatedDate
    private LocalDate dataInclusao;
    private LocalDate dataExpiracao;
    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Visitante visitante;

    public Visita(Long id, Integer numeroApartamento, String nomeTorre, LocalDate dataInclusao, LocalDate dataExpiracao) {
        this.id = id;
        this.numeroApartamento = numeroApartamento;
        this.nomeTorre = nomeTorre;
        this.dataInclusao = dataInclusao;
        this.dataExpiracao = dataExpiracao;
    }
    public Visita() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(Integer numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public String getNomeTorre() {
        return nomeTorre;
    }

    public void setNomeTorre(String nomeTorre) {
        this.nomeTorre = nomeTorre;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
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
                ", numeroApartamento=" + numeroApartamento +
                ", nomeTorre='" + nomeTorre + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", dataExpiracao=" + dataExpiracao +
                '}';
    }


}
