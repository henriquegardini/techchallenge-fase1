package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visitante")
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String documento;
    private String telefone;
    @OneToMany(mappedBy = "visitante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Visita> visitas = new ArrayList<>();

    public Visitante() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Visitante(String nome, String documento, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public void addVisita(Visita visita){
        this.visitas.add(visita);
        visita.setVisitante(this);
    }


    public List<Visita> getVisitas() {
        return this.visitas;
    }
}
