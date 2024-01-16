package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "visitante")
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String rg;
    private String telefone;
    @OneToMany(mappedBy = "visitante", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Visita> visita;

}
