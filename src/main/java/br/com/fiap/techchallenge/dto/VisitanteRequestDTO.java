package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entities.Visita;

import java.util.List;

public class VisitanteRequestDTO {
    private Long id;
    private String nome;
    private String documento;
    private String telefone;
    private List<Visita> visitas;

    public VisitanteRequestDTO(Long id,String nome, String documento, String telefone, List<Visita> visitas) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.visitas = visitas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
}