package br.com.fiap.techchallenge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "morador")
public class Morador {
    private String nome;
    @Id
    private String documento;
    private String email;
    private String telefone;
    private Integer apartamento;
    private Integer andar;
    private String torre;
    private LocalDate inclusao;
    private LocalDate atualizacao;

    public Morador() {
    }

    public Morador(String nome, String documento, String email, String telefone, Integer apartamento, Integer andar, String torre, LocalDate inclusao, LocalDate atualizacao) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
        this.apartamento = apartamento;
        this.andar = andar;
        this.torre = torre;
        this.inclusao = inclusao;
        this.atualizacao = atualizacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public LocalDate getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(LocalDate atualizacao) {
        this.atualizacao = atualizacao;
    }
}
