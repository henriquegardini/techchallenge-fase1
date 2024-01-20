package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entities.Visita;

import java.util.List;

public class VisitanteRequestDTO {
    private String nome;
    private String documento;
    private String telefone;
    private List<Visita> visitas;

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
