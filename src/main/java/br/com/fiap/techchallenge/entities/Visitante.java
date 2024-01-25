package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/* PENDENCIAS
Ponto 1: Validar se faz sentido atualizar todos os campos do visitante.
	Sugestão: faz sentido atualizar os campos nome e telefone.

Ponto 2: Validar se faz sentido atualizar todos os campos das visitas.
	Sugestão: faz sentido a chave de atualização ser documento, apartamento, andar e torre e faz sentido atualizar apenas o campo expiração.

Ponto 3: Quando for cadastrado a visita para o apartamento errado, como deve ser tratado o cadastro do apartamento certo.
	Sugestão: Atualizar o registro do apartamento errado com os dados do apartamento certo.

Ponto 4: Ficou estranho não informar o apartamento da solicitação de acesso.
	Sugestão: Na liberação de acesso, incluir os campo apartamento, andar e torre além do documento.
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
