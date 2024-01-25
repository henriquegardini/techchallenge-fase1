package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/* PENDENCIAS
4- Implementar as políticas e os agregados;
5- Criar o crud da entidade visitas
6- Criar as consultas dos moradores.
*/
@Entity
@Table(name = "visitante")
public class Visitante {

    @Id
    private String documento;
    private String nome;
    private String telefone;
    @OneToMany(mappedBy = "visitante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Visita> visitas = new ArrayList<>();

    public Visitante() {

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

    public Visitante(String documento, String nome, String telefone) {
        this.documento = documento;
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                ", documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
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
