package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_visita")
public class VisitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer numeroApartamento;
    private String nomeTorre;
    private LocalDate dataInclusao;
    private LocalDate dataExpiracao;

    public VisitaEntity() {

    }

    public VisitaEntity(UUID id, Integer numeroApartamento, String nomeTorre, LocalDate dataInclusao, LocalDate dataExpiracao) {
        this.id = id;
        this.numeroApartamento = numeroApartamento;
        this.nomeTorre = nomeTorre;
        this.dataInclusao = dataInclusao;
        this.dataExpiracao = dataExpiracao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        if (o == null || getClass() != o.getClass()) return false;
        VisitaEntity that = (VisitaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "VisitaEntity{" +
                "id=" + id +
                ", numeroApartamento=" + numeroApartamento +
                ", nomeTorre='" + nomeTorre + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", dataExpiracao=" + dataExpiracao +
                '}';
    }

}